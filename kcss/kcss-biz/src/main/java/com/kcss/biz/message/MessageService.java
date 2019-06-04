package com.kcss.biz.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;

@Service
public class MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private Environment env;

    public void generateMessage(MessageConstants.MsgTrigger trigger) {

    }
    private List<MessageEntity> findWaitingMessagesByTrigger(MessageConstants.MsgTrigger trigger) {
        return messageMapper.findMessagesByTrigger(trigger, MessageEntity.Status.WAITING);
    }

    public String loadMessageContent(MessageConstants.MsgTemplateType type, MessageConstants.MsgTemplateApplication application, Object[] arguments) {
        MessageTemplateEntity messageTemplateEntity = messageMapper.findMessageTemplate(type, application);
        if (messageTemplateEntity == null) {
            logger.error("未找到[{}]的消息模板", application);
            throw new MessageException("no message template found.");
        }
        if (StringUtils.isEmpty(messageTemplateEntity.getContent())) {
            logger.error("[{}]的消息模板内容未空", application);
            throw new MessageException("no message template found.");
        }
        if (arguments == null || arguments.length == 0) {
            return messageTemplateEntity.getContent();
        } else {
            return MessageFormat.format(messageTemplateEntity.getContent(), arguments);
        }

    }


}
