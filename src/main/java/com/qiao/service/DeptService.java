package com.qiao.service;

import com.qiao.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    //查询全部部门数据
    List<Dept> list();
    //删除部门
    void delete(Integer id);
    //新增部门
    void add(Dept dept);
    //修改部门
    void update(Dept dept);
    //根据id查询部门
    Dept selectId(Integer id);
}
