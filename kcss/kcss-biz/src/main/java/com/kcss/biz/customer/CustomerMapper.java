package com.kcss.biz.customer;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {

    @Select("SELECT * FROM t_student_teacher WHERE college_id = #{collegeId} AND type=#{type} AND mark_no = #{account}")
    List<CustomerEntity> findUser(@Param("account") String account, @Param("collegeId") Long collegeId, @Param("type") String type);

    @Select("SELECT * FROM t_student_teacher WHERE id = #{id}")
    CustomerEntity findUserById(@Param("id") Long id);

    @Update("UPDATE t_student_teacher SET mobile = #{mobile} ,update_time = now() WHERE id = #{id}")
    int updateCustomerBindMobile(@Param("id") Long id, @Param("mobile") String mobile);

    @Select("SELECT COUNT(id) FROM  t_student_teacher WHERE mobile = #{mobile}")
    int haveThisMobile(@Param("mobile") String mobile);

    @Select("SELECT * FROM t_student_teacher WHERE mobile = #{mobile} LIMIT 1")
    CustomerEntity findCustomerByMobile(@Param("mobile") String mobile);

    @Update("UPDATE t_student_teacher SET password = #{mobile} ,update_time = now() WHERE mobile = #{mobile}")
    int updateCustomerPassworByMobile(@Param("password") String password, @Param("mobile") String mobile);

    @Update("UPDATE t_student_teacher SET head_file_id = #{headFileId} ,update_time = now() WHERE id = #{id}")
    int updateCustomerHeadFileIdById(@Param("id") Long id, @Param("headFileId") Long headFileId);
}
