package com.fdzc.springboot.service;

import com.fdzc.springboot.entity.User;
import com.fdzc.springboot.vo.UserVo;

import java.util.List;

public interface UserService {
//    @Select("select * from user")
    List<User> getAllUsers();
    User selectById(Integer id);
    Integer insertToUser(User user);
    Integer insertToUsers(List<User> users);
    Integer updateById(Integer id, User user);
    Integer deleteById(Integer id);
    Integer deleteBatch(Integer[] userIds);
    UserVo findUserDept(Integer id);
    List<UserVo> findUsersDept(List<Integer> ids);
    List<UserVo> findUserDeptAll();
}
