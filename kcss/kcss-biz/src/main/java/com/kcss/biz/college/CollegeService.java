package com.kcss.biz.college;

import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CollegeService class.
 *
 * @author X
 * @date: 2018/11/15
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Service
public class CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    public XResponse<List<CollegeEntity>> college(CustomerEntity.CustomerType customerType, CollegeEntity.CollegeType collegeType) {
        List<CollegeEntity> colleges = colleges(customerType,collegeType);
        return new XResponse<List<CollegeEntity>>(){{
            setData(colleges);
        }};
    }

    //根据用户类型与院企类型
    public List<CollegeEntity> colleges(CustomerEntity.CustomerType customerType, CollegeEntity.CollegeType collegeType){
        return collegeMapper.colleges(customerType,collegeType);
    }
}
