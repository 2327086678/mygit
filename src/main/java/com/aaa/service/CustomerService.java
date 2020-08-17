package com.aaa.service;

import com.aaa.dao.CustomerDao;
import com.aaa.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerService {
    @Resource
    CustomerDao customerDao;

    public Customer findByCname(String cname){
        return customerDao.findByCname(cname);
    }
}
