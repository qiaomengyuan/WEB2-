package com.qiao.controller;

import com.qiao.anno.Log;
import com.qiao.pojo.Dept;
import com.qiao.pojo.Result;
import com.qiao.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //private static Logger log = (Logger) LoggerFactory.getLogger(DeptController.class);
   @Autowired
    private DeptService deptService;
    //查询部门
    @GetMapping
    public Result list(){

        log.info("查询全部日志");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    //删除部门
    @Log
    @DeleteMapping("{id}")
    public Result list(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        log.info("根据id1删除部门乔梦圆:{}",id);
        deptService.delete(id);
        return Result.success();
    }
    //新增部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    //根据id查找部门
    @GetMapping("{id}")
    public Result selectId(@PathVariable Integer id){
        log.info("根据id查找部门：",id);
        Dept dept = deptService.selectId(id);

        return Result.success(dept);
    }

    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门{}",dept);
        deptService.update(dept);
        return Result.success();
    }



}