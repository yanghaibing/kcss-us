package com.kcss.biz.message.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcss.biz.config.CacheConfig;
import com.kcss.biz.message.MessageConstants;
import com.kcss.biz.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChuanglanSmsSendingService implements SmsSendingService{
    private static final Logger logger = LoggerFactory.getLogger(ChuanglanSmsSendingService.class);

    @Value("${chuanglan.account.name}")
    private String account;
    @Value("${chuanglan.account.password}")
    private String password;
    @Value("${chuanglan.url.template}")
    private String urlTemplate;

    @Autowired
    private SmsMapper smsMapper;
    @Autowired
    private CacheManager cacheManager;
    private Cache smsCodeCache;
    @Autowired
    private MessageService messageService;
    @Autowired
    private Environment env;
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        smsCodeCache = cacheManager.getCache(CacheConfig.SMS_CODE_CACHE);
    }


    @Override
    public void sendCode(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, String code) {
        String productName = env.getProperty("merchant.product.name");
        SmsEntity sms = buildSmsEntity(code, trigger, sendto, application, new String[] {productName, code});
        smsCodeCache.put(sendto + ":" + code, 1);

        smsMapper.createSms(sms);
        send(sms);
    }

    @Override
    public boolean validateCode(String prefix, String code) {
        return smsCodeCache.get(prefix + ":" + code) != null;
    }

    @Override
    public void sendTemplate(MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, Object[] arguments) {
        SmsEntity sms = buildSmsEntity(null, trigger, sendto, application, arguments);
        smsMapper.createSms(sms);
        send(sms);
    }

    @Override
    public int send(SmsEntity sms) {
        sms.setStatus(SmsEntity.Status.SENDING);
        smsMapper.updateSms(sms);
        try {
            Map<String, String> requestMap = new HashMap<>();
            requestMap.put("account", account);
            requestMap.put("password", password);
            requestMap.put("phone", sms.getSendto());
            requestMap.put("msg", sms.getContent());
            String requestBody = new ObjectMapper().writeValueAsString(requestMap);
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(requestBody, headers);
            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.postForObject(urlTemplate, formEntity, HashMap.class, requestMap);
            sms.setResponse(response.toString());
            if("0".equals(response.get("code"))){
                sms.setStatus(SmsEntity.Status.SUCCESS);
            } else {
                throw new RuntimeException("sms send fail");
            }
            return smsMapper.updateSms(sms);
        } catch (Exception exception) {
            logger.error("Sending sms error: sms - {}, exception - {} ", sms, exception);
            sms.setStatus(SmsEntity.Status.FAILED);
            return smsMapper.updateSms(sms);
        }
    }

    @Override
    public MessageConstants.MsgSender getSmsSender() {
        return MessageConstants.MsgSender.CHUANG_LAN;
    }

    private SmsEntity buildSmsEntity(String code, MessageConstants.MsgTrigger trigger, String sendto, MessageConstants.MsgTemplateApplication application, Object[] arguments) {
        return new SmsEntity() {{
            setSender(MessageConstants.MsgSender.CHUANG_LAN);
            setStatus(Status.WAITING);
            setCode(code);
            setSendTrigger(trigger);
            setSendto(sendto);
            setContent(messageService.loadMessageContent(MessageConstants.MsgTemplateType.SMS, application, arguments));
        }};
    }
}
