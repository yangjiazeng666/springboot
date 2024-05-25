package com.fdzc.springboot.mapper;

import com.fdzc.springboot.entity.Dept;
import com.fdzc.springboot.vo.DeptVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DeptMapper {
    // 查询所有部门信息
    List<Dept> selectAll();
    // 根据单个ID查询部门信息
    Dept selectById(Integer id);
    // 添加新部门
    Integer insert(Dept dept);
    //批量添加部门
    Integer insertBatch(List<Dept> depts);
    // 根据ID更新部门信息
    Integer update(Integer id,Dept dept);
    // 根据ID删除部门信息
    Integer delete(Integer id);
    //批量删除部门信息
    Integer deleteBatch(Integer[] deptIds);
    //根据单个id查找部门里的用户信息
    DeptVo findDeptUser(Integer id);
    //根据多个id查找部门里的用户信息
    List<DeptVo> findDeptUsers(List<Integer> ids);
    //查找所有部门里的用户
    List<DeptVo> findDeptUserAll();
}

//@Select("SELECT * FROM dept")
// @Select("SELECT * FROM dept WHERE id = #{id}")
// @Insert("INSERT INTO dept(dept_name, description, address) VALUES(#{deptName}, #{description}, #{address})")
// @Update("UPDATE dept SET dept_name = #{deptName}, description = #{description}, address = #{address} WHERE id = #{id}")
// @Delete("DELETE FROM dept WHERE id = #{id}")