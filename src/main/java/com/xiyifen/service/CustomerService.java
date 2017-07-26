package com.xiyifen.service;

import com.xiyifen.pojo.BaseDict;
import com.xiyifen.pojo.Customer;
import com.xiyifen.pojo.QueryVo;

import java.util.List;

public interface CustomerService {
    public List<BaseDict> findDictByCode(String code);
    public List<Customer> findCustomerByVo(QueryVo vo);
    public Integer findCustomerByVoCount(QueryVo vo);
    public Customer findCustomerById(Long id);
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Long id);
}
