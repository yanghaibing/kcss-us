package com.kcss.biz.record.auth.token;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenMapper {

    @Insert("INSERT INTO T_TOKEN(SUBJECT, TOKEN, EXPIRED_TIME, REFRESH_TOKEN, REFRESH_EXPIRED_TIME, METADATA) " +
            " VALUES(#{subject}, #{token}, #{expiredTime}, #{refreshToken}, #{refreshExpiredTime}, #{metadata})")
    @Options(useGeneratedKeys = true)
    int createToken(TokenEntity tokenEntity);

    @Select("SELECT * FROM T_TOKEN WHERE TOKEN = #{token} AND EXPIRED_TIME > NOW() LIMIT 1")
    TokenEntity findToken(@Param("token")String token);

    @Select("SELECT * FROM T_TOKEN WHERE REFRESH_TOKEN = #{refreshToken} AND REFRESH_EXPIRED_TIME > NOW() LIMIT 1")
    TokenEntity findRefreshToken(@Param("refreshToken")String refreshToken);

    @Update("UPDATE T_TOKEN SET EXPIRED_TIME = NOW(), REFRESH_EXPIRED_TIME = NOW() WHERE TOKEN = #{token}")
    int invalidToken(@Param("token")String token);

    @Update("UPDATE T_TOKEN SET REFRESH_EXPIRED_TIME = NOW() WHERE REFRESH_TOKEN = #{refreshToken}")
    int invalidRefreshToken(@Param("refreshToken") String refreshToken);

    @Update("UPDATE T_TOKEN SET EXPIRED_TIME = NOW(), REFRESH_EXPIRED_TIME = NOW() WHERE SUBJECT = #{subject} AND METADATA = #{metaData} AND (EXPIRED_TIME > NOW() OR REFRESH_EXPIRED_TIME > NOW())")
    int invalidAllTokens(@Param("subject")String subject,@Param("metaData")String metaData);

    @Delete("DELETE FROM T_TOKEN WHERE REFRESH_EXPIRED_TIME < CURRENT_DATE - 1")
    int deleteExpiredTokens();

    @Update("UPDATE T_TOKEN SET EXPIRED_TIME = NOW(), REFRESH_EXPIRED_TIME = NOW() WHERE SUBJECT = #{subject} AND (EXPIRED_TIME > NOW() OR REFRESH_EXPIRED_TIME > NOW())")
    int invalidateSubject(String subject);
}
