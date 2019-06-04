package com.kcss.biz.college;

import com.kcss.biz.customer.CustomerEntity;
import com.kcss.core.util.sql.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * CollegeProvider class.
 *
 * @author X
 * @date: 2018/11/15
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
public class CollegeProvider {

    public String colleges(Map<String, Object> params){
        return new SQL(){{
            SELECT("*");
            FROM("T_COLLEGE");
            WHERE("status='ACTIVE'");
            //如果是学生
            if(CustomerEntity.CustomerType.STUDENT.name().equals(params.get("customerType"))){
                WHERE("type='COLLEGE'");
            }else{
                //老师
                WHERE_IF("type=#{collegeType}",!StringUtils.isEmpty(params.get("collegeType")));
            }
        }}.toString();
    }
}
