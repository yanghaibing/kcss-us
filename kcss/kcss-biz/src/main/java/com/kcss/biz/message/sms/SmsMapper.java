package com.kcss.biz.message.sms;

import com.kcss.biz.message.MessageConstants;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SmsMapper {

    @Insert("INSERT INTO T_SMS(SENDER, SEND_TRIGGER, SENDTO, CODE, CONTENT, STATUS, RESPONSE) " +
            " VALUES(#{sender}, #{sendTrigger}, #{sendto}, #{code}, #{content}, #{status}, #{response})")
    @Options(useGeneratedKeys = true)
    int createSms(SmsEntity smsEntity);

    @Insert("UPDATE T_SMS SET STATUS = #{status}, RESPONSE = #{response}, SENDER = #{sender}, UPDATE_TIME = NOW() WHERE ID = #{id}")
    @Options(useGeneratedKeys = true)
    int updateSms(SmsEntity smsEntity);

    @Select("SELECT * FROM T_SMS WHERE MOBILE = #{mobile} AND CODE = #{code} ORDER BY CREATE_TIME DESC LIMIT 1")
    SmsEntity findLatestSms(@Param("mobile") String mobile, @Param("code") String code);

    @Select("SELECT * FROM T_SMS " +
            " WHERE SEND_TRIGGER = #{trigger} " +
            "       AND STATUS = 'WAITING' " +
            "       AND CREATE_TIME >= (NOW() - interval '1' hour * #{expireHours})" +
            " ORDER BY CREATE_TIME ASC")
    List<SmsEntity> findWaitingSmsByTrigger(@Param("trigger") MessageConstants.MsgTrigger trigger, @Param("expireHours") int expireHours);

    @Select("SELECT * FROM T_SMS WHERE SENDTO = #{mobile} AND SEND_TRIGGER = 'REGISTER' ORDER BY ID DESC LIMIT 20")
    List<SmsEntity> findSmsByMobile(@Param("mobile") String mobile);



}
