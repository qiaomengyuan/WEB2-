package com.qiao.controller;

import com.qiao.anno.Log;
import com.qiao.pojo.Emp;
import com.qiao.pojo.PageBean;
import com.qiao.pojo.Result;
import com.qiao.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    //分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name,gender,begin,end);
        //调用Service
        PageBean pageBean = empService.page(page, pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    //删除员工
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
            log.info("批量删除操作，ids:{}",ids);
            empService.delete(ids);
        return Result.success();
    }
    //新增员工
    @Log
    @PostMapping
    public  Result save(@RequestBody Emp emp){
        log.info("新增员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }
    //根据id找到员工
    @GetMapping("/{id}")
    public  Result getById(@PathVariable Integer id){
        log.info("查询员工的id为");//查询员工
        Emp emp = empService.getById(id);
        return Result.success(emp);

    }
    //修改员工
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
