package com.qiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiao.mapper.EmpMapper;
import com.qiao.pojo.Emp;
import com.qiao.pojo.PageBean;
import com.qiao.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    //  分页查询
        @Override
        public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
           //1.设置分页参数
            PageHelper.startPage(page,pageSize);
            //2.执行查询
            List<Emp> empList = empMapper.list(name, gender, begin, end);
            Page<Emp> p =(Page<Emp>) empList;
            //3.封装成pageBean对象
            PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
            return pageBean;
        }
   //删除员工
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
   //增加员工
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
   //根据id查询员工信息
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);

    }
   //修改员工
    @Override
    public void update(Emp emp) {
       emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassord(emp);
    }
}
