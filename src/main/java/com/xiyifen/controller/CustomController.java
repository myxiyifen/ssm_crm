package com.xiyifen.controller;

import cn.itcast.utils.Page;
import com.xiyifen.pojo.BaseDict;
import com.xiyifen.pojo.Customer;
import com.xiyifen.pojo.QueryVo;
import com.xiyifen.service.CustomerService;
import com.xiyifen.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("custom")
public class CustomController {
    @Autowired
    private CustomerService customerService;
    @Value("${customer.dict.source}")
    private String source;
    @Value("${customer.dict.industry}")
    private String industry;
    @Value("${customer.dict.level}")
    private String level;

    @RequestMapping("list")
    public String list(QueryVo vo, Model model) throws Exception {

        //客户来源
        List<BaseDict> sourceList=customerService.findDictByCode(source);
        List<BaseDict> industryList=customerService.findDictByCode(industry);
        List<BaseDict> levelList=customerService.findDictByCode(level);

        if(vo.getCustName() != null){
            vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"), "utf-8"));
        }

        if(vo.getPage() == null){
            vo.setPage(1);
        }

        //设置查询的起始记录条数
        vo.setStart((vo.getPage() - 1) * vo.getSize());

        //查询数据列表和数据总数
        List<Customer> resutList = customerService.findCustomerByVo(vo);
        Integer count = customerService.findCustomerByVoCount(vo);

        Page<Customer> page = new Page<Customer>();
        page.setTotal(count);		//数据总数
        page.setSize(vo.getSize());	//每页显示条数
        page.setPage(vo.getPage()); //当前页数
        page.setRows(resutList);	//数据列表

        model.addAttribute("page", page);


        model.addAttribute("fromType",sourceList);
        model.addAttribute("industryType",industryList);
        model.addAttribute("levelType",levelList);


        //TODo  可能乱码

        //高级查询选中数据回显
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());
        return "customer";
    }

    @RequestMapping("detail")
    @ResponseBody
    public Customer detail(Long id) throws Exception{
        Customer customer = customerService.findCustomerById(id);
        return customer;

    }
    @RequestMapping("update")
    public String update(Customer customer){
        customerService.updateCustomerById(customer);

        return "customer";
    }

    @RequestMapping("delete")
    public String delete(Long id) throws Exception{
        customerService.deleteCustomerById(id);
        return "customer";
    }
}
