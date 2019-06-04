package com.kcss.admin.auth;

import com.kcss.admin.admin.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthMapper {

    @Select("SELECT * FROM T_ADMIN WHERE MOBILE = #{mobile} LIMIT 1")
    AdminEntity findOneByMobile(String mobile);

    @Update("UPDATE T_ADMIN SET UPDATE_TIME = NOW(), FAILED_LOGIN_COUNT = 0 WHERE MOBILE = #{mobile}")
    int updateLoginSuccessByMobile(String mobile);

    @Update("UPDATE T_ADMIN SET UPDATE_TIME = NOW(), FAILED_LOGIN_COUNT = FAILED_LOGIN_COUNT + 1 WHERE MOBILE = #{mobile}")
    int updateLoginFailedByMobile(String mobile);

}
