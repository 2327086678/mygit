package com.aaa.dao;

import com.aaa.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerDao {
    @Select("select * from customer where cname = #{cname}")
    Customer findByCname(String cname);
}
