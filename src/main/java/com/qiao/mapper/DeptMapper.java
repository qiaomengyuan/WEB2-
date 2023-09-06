package com.qiao.mapper;

import com.qiao.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    //查询全部部门
    @Select("select * from tlias.dept")
    List<Dept> list();

    //根据id删除部门
    @Delete("delete from tlias.dept where id = #{id}")
    void deleteById(Integer id);

    //新增部门
    @Insert("insert into tlias.dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    //修改部门

    void update(Dept dept);

    //查找部门的id
    @Select("select * from tlias.dept where id = #{id}")
    Dept selectId(Integer id);


}
