package com.kcss.biz.customer;

import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.customer.CustomerMapper;
import com.kcss.biz.record.auth.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * CustomerService class.
 *
 * @author X
 * @date: 2018/11/27
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private TokenService tokenService;

    @Value("${file.url.profix}")
    private String fileUrlProfix;

    public CustomerEntity findUserById(Long id) {
        CustomerEntity customerEntity = customerMapper.findUserById(id);
        return changeFile(customerEntity);
    }

    //文件替换
    public CustomerEntity changeFile(CustomerEntity customerEntity){
        customerEntity.setHeadUrl(fileUrlProfix+customerEntity.getHeadFileId());
        return customerEntity;
    }

    //返回用户信息
    public XResponse<CustomerEntity> info(String token){
        CustomerEntity customer = tokenService.getCustomer(token);
        return new XResponse<CustomerEntity>(){{
            setData(customer);
        }};
    }

    //修改信息
    public XResponse update(String token, String headerUrl) {

        return null;
    }
}
