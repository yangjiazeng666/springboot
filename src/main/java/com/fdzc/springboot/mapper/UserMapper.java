package com.fdzc.springboot.mapper;

import com.fdzc.springboot.entity.User;
import com.fdzc.springboot.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询所有用户信息
    List<User> selectAll();
    // 根据ID查询用户信息
    User selectById(Integer id);
    // 添加用户信息
    Integer insertToUser(User user);
    // 批量添加用户信息
    Integer insertToUsers(List<User> users);
    // 根据ID更新用户信息
    Integer update(Integer id,User user);
    // 根据ID删除用户信息
    Integer delete(Integer id);
    //批量删除用户信息
    Integer deleteBatch(Integer[] userIds);
    //根据单个id查找用户里的部门信息
    UserVo findUserDept(Integer id);
    //根据多个id查找用户里的部门信息
    List<UserVo> findUsersDept(List<Integer> ids);
    // 查询所有用户及其部门信息的列表
    List<UserVo> findUserDeptAll();
}

//    @Select("select * from user")
//    @Select("select * from user where id = #{id}")
//    @Insert("insert into user(user_name,password) values(#{userName},#{password})")
//    @Update("update user set user_name=#{userName} where id=#{id}")
//    @Delete("delete from user where id=#{id}")