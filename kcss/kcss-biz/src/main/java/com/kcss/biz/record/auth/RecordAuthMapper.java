package com.kcss.biz.record.auth;

import com.kcss.biz.customer.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordAuthMapper {

    @Update("UPDATE T_STUDENT_TEACHER SET LAST_LOGIN_TIME = NOW(), FAILED_LOGIN_COUNT = 0 WHERE ID = #{id}")
    int updateLoginSuccessById(@Param("id") Long id);


    @Select("SELECT * FROM T_STUDENT_TEACHER WHERE ID = #{id}")
    CustomerEntity findOneById(@Param("id")Long id);
}
