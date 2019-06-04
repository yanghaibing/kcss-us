package com.kcss.biz.message;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    @Insert("INSERT INTO T_MESSAGE(CUSTOMER_ID, LOAN_APP_ID, TRIGGER, STATUS, SMS_STATUS, APP_PUSH_STATUS, APP_INBOX_STATUS, MESSAGE_BODY) " +
            "VALUES (#{customerId}, #{loanAppId}, #{trigger}, #{status}, #{smsStatus}, #{appPushStatus}, #{appInboxStatus}, #{messageBody})")
    @Options(useGeneratedKeys = true)
    int createMessage(MessageEntity messageEntity);

    @Select("SELECT * FROM T_MESSAGE WHERE TRIGGER = #{trigger} AND STATUS = #{status}")
    List<MessageEntity> findMessagesByTrigger(@Param("trigger") MessageConstants.MsgTrigger trigger, @Param("status") MessageEntity.Status status);

    @Update("UPDATE T_MESSAGE SET STATUS = #{status}, SMS_STATUS = #{smsStatus}, APP_PUSH_STATUS = #{appPushStatus}, APP_INBOX_STATUS = #{appInboxStatus} WHERE ID = #{id}")
    int updateMessageStatus(MessageEntity messageEntity);

    @Select("SELECT * FROM T_MESSAGE_TEMPLATE WHERE TYPE=#{type} AND APPLICATION=#{application}")
    MessageTemplateEntity findMessageTemplate(@Param("type") MessageConstants.MsgTemplateType type, @Param("application") MessageConstants.MsgTemplateApplication application);
}
