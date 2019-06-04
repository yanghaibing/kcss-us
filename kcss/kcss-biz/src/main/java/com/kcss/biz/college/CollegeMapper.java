package com.kcss.biz.college;

import com.kcss.biz.customer.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeMapper {

    @SelectProvider(method = "colleges",type = CollegeProvider.class)
    List<CollegeEntity> colleges(@Param("customerType") CustomerEntity.CustomerType customerType,@Param("collegeType") CollegeEntity.CollegeType collegeType);

}
