package com.fdzc.springboot.service;

import com.fdzc.springboot.entity.User;
import com.fdzc.springboot.mapper.UserMapper;
import com.fdzc.springboot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }
    public Integer insertToUser(User user){
        return userMapper.insertToUser(user);
    }
    public Integer insertToUsers(List<User> users){
        return userMapper.insertToUsers(users);
    }
    public Integer updateById(Integer id, User user){
        return userMapper.update(id,user);
    }
    public Integer deleteById(Integer id){
        return userMapper.delete(id);
    }
    public Integer deleteBatch(Integer[] userIds){
        return userMapper.deleteBatch(userIds);
    }
    public UserVo findUserDept(Integer id){
        return userMapper.findUserDept(id);
    }
    public List<UserVo> findUsersDept(List<Integer> ids){
        return userMapper.findUsersDept(ids);
    }
    public List<UserVo> findUserDeptAll(){
        return userMapper.findUserDeptAll();
    }
}
