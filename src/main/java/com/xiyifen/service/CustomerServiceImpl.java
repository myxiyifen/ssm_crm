package com.xiyifen.service;

import com.xiyifen.dao.CustomerMapper;
import com.xiyifen.dao.DictMapper;
import com.xiyifen.pojo.BaseDict;
import com.xiyifen.pojo.Customer;
import com.xiyifen.pojo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private CustomerMapper customerMapper;
    public List<BaseDict> findDictByCode(String code) {
        List<BaseDict> dictByCode = dictMapper.findDictByCode(code);
        return dictByCode;
    }

    public List<Customer> findCustomerByVo(QueryVo vo) {
        List<Customer> customerByVo = customerMapper.findCustomerByVo(vo);
        return customerByVo;
    }

    public Integer findCustomerByVoCount(QueryVo vo) {
        Integer customerByVoCount = customerMapper.findCustomerByVoCount(vo);
        return customerByVoCount;
    }

    public Customer findCustomerById(Long id) {

        Customer customer = customerMapper.findCustomerById(id);
        return customer;
    }

    public void updateCustomerById(Customer customer) {
       customerMapper.updateCustomerById(customer);
    }

    public void deleteCustomerById(Long id) {
        customerMapper.deleteCustomerById(id);
    }
}
