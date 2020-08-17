package com.aaa.security;

import com.aaa.entity.Customer;
import com.aaa.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConfig implements UserDetailsService {

    @Resource
    CustomerService customerService;

    /**
     * 根据用户名加载用户信息
     * @param s 表单提交的用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerService.findByCname(s);
        System.out.println("s:"+s);
        System.out.println(customer);
        if(customer == null){
            throw new UsernameNotFoundException("用户没有找到");
        }
        return customer;
    }

}
