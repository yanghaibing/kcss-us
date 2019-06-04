package com.kcss.biz.message.sms;

import com.kcss.biz.message.MessageConstants;
import org.springframework.stereotype.Service;

@Service
public interface SmsSendingService {

    void sendCode(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, String code);

    boolean validateCode(String prefix, String code);

    void sendTemplate(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, Object[] arguments);

    int send(SmsEntity sms);

    MessageConstants.MsgSender getSmsSender();

}
