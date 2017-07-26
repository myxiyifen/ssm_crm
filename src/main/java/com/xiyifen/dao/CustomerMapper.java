package com.xiyifen.dao;

import com.xiyifen.pojo.Customer;
import com.xiyifen.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    public List<Customer> findCustomerByVo(QueryVo queryVo);

    public Integer findCustomerByVoCount(QueryVo queryVo);

    public Customer findCustomerById(Long id);
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Long id);
}
