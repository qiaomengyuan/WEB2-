package com.qiao.service;

import com.qiao.pojo.Emp;
import com.qiao.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    //分页查询方法
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
   //批量删除
    void delete(List<Integer> ids);
   //新增员工
    void save(Emp emp);
    //根据id查询员工信息
    Emp getById(Integer id);
    //修改员工
    void update(Emp emp);
    //员工登录操作
    Emp login(Emp emp);
}
