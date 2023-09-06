package com.qiao.mapper;

import com.qiao.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    //    //分页条件查询总记录数
    //@Select("select * from tlias.emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    //批量删除员工
    void delete(List<Integer> ids);
    //新增员工
    @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time ) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    void insert(Emp emp);

    //根据id查询员工
    @Select("select * from tlias.emp where id = #{id}")
    public Emp getById(Integer id);
    //修改员工
    void update(Emp emp);
   //根据用户名和密码查询员工
    @Select("select * from tlias.emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassord(Emp emp);
    //根据部门id删除部门下的员工数据
    @Delete("delete  from tlias.emp where dept_id = #{deptId}")
    void deleteBYDeptId(Integer deptId);
}
