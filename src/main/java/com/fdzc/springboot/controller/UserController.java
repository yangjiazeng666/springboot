package com.fdzc.springboot.controller;

import com.fdzc.springboot.entity.User;
import com.fdzc.springboot.service.UserService;
import com.fdzc.springboot.vo.UserVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // 查询所有用户信息
    @GetMapping("/findUserAll")
    public List<User> selectAll() {
        return userService.getAllUsers();
    }
    // 根据ID查询用户信息
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        logger.info(id.toString());
        User user = userService.selectById(id);
        return user;
    }

    // 添加用户信息
    @PostMapping("/insertUser")
    public String addUser(@RequestBody User user) {
        try {
            logger.debug(user.toString());
            int count=userService.insertToUser(user);
            return "成功添加了"+count+"条数据";
        }catch (RuntimeException e){
            return "添加失败: " + e.getMessage();
        }
    }
    // 批量添加用户信息
    @PostMapping("/insertBatch")
    public String addUsers(@RequestBody List<User> users) {
        try {
            logger.info(users.toString());
            int count=userService.insertToUsers(users);
            return "成功添加了"+count+"条数据";
        }catch (RuntimeException e){
            return "添加失败: " + e.getMessage();
        }
    }

    // 根据ID更新用户信息
    @PutMapping("/{id}")
    public String updateUserById(@PathVariable Integer id,@RequestBody User user) {
        try {
            logger.info(user.toString());
            int count=userService.updateById(id,user);
            return "成功更新了"+count+"条数据";
        }catch (RuntimeException e){
            return "更新失败: " + e.getMessage();
        }
    }


    // 根据ID删除用户信息
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        try {
            logger.info(id.toString());
            int count=userService.deleteById(id);
            return "成功删除了"+count+"条数据";
        }catch (RuntimeException e){
            return "删除失败: " + e.getMessage();
        }
    }
    // 批量删除用户信息
    @DeleteMapping("deleteBatch")
    public String deleteUsers(@RequestBody Integer[] userIds) {
        try {
            logger.info(Arrays.toString(userIds));
            int count=userService.deleteBatch(userIds);
            return "成功删除了"+count+"条数据";
        }catch (RuntimeException e){
            return "删除失败: " + e.getMessage();
        }
    }

    //根据单个id查找用户里的部门信息
    @GetMapping("/findUserDept/{id}")
    public UserVo findUserDept(@PathVariable Integer id){
        logger.info(id.toString());
        return userService.findUserDept(id);
    }
    //根据多个id查找用户里的部门信息
    @PostMapping("/findUsersDept")
    public List<UserVo> findUsersDept(@RequestBody List<Integer> ids){
        logger.info(ids.toString());
        return userService.findUsersDept(ids);
    }
   //  查询所有用户及其部门信息的列表
    @GetMapping("/findUserDeptAll")
    public List<UserVo> findUserDeptAll() {
        return userService.findUserDeptAll();
    }

}
