package com.kcss.biz.message.sms;

import com.kcss.biz.message.MessageConstants;
import com.kcss.core.util.messageresource.MessageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Service
public class SmsService {

    private final Logger logger = LoggerFactory.getLogger(SmsService.class);

    @Autowired
    private SmsMapper smsMapper;
    
    @Autowired
    private SmsSendingService smsSendingService;

    @Autowired
    private MessageHelper messageHelper;

    private ScheduledThreadPoolExecutor executorService;

    @PostConstruct
    private void init() {
        executorService = new ScheduledThreadPoolExecutor(3);
        executorService.setMaximumPoolSize(5);
    }

    public void sendCode(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, String code) {
        smsSendingService.sendCode(trigger, sendto, application, code);
    }

    public void sendTemplate(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, Object[] arguments) {
        smsSendingService.sendTemplate(trigger, sendto, application, arguments);
    }

    public Optional<SmsEntity> reserveSms(MessageConstants.MsgTrigger trigger, String sendto, String message) {
        SmsEntity sms = new SmsEntity() {{
            setSender(MessageConstants.MsgSender.UNKNOWN_YET);
            setStatus(Status.WAITING);
            setCode(null);
            setSendTrigger(trigger);
            setSendto(sendto);
            setContent(message);
        }};

        if (smsMapper.createSms(sms) == 1) {
            return Optional.of(sms);
        }

        return Optional.empty();
    }

    public List<SmsEntity> findSmsByMobile(String mobile) {
        return smsMapper.findSmsByMobile(mobile);
    }

    public boolean validateCode(String mobile, String code) {
        return smsSendingService.validateCode(mobile, code);
    }


    public void sendSms(SmsEntity smsEntity) {
        smsEntity.setSender(smsSendingService.getSmsSender());
        executorService.submit(() -> smsSendingService.send(smsEntity));
    }

}
