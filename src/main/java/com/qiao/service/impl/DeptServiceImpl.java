package com.qiao.service.impl;

import com.qiao.mapper.DeptMapper;
import com.qiao.mapper.EmpMapper;
import com.qiao.pojo.Dept;
import com.qiao.service.DeptService;
import com.qiao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    @Transactional(rollbackFor = Exception.class)//spring事务管理,出现所有异常回滚
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id); //根据ID删除部门

        empMapper.deleteBYDeptId(id);//根据部门id删除该部门下的员工

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept selectId(Integer id) {
        return deptMapper.selectId(id);
    }

}
