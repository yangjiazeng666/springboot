package com.fdzc.springboot;

import com.fdzc.springboot.entity.User;
import com.fdzc.springboot.mapper.DeptMapper;
import com.fdzc.springboot.mapper.UserMapper;
import com.fdzc.springboot.vo.DeptVo;
import com.fdzc.springboot.vo.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyBatisDemo {
    private static SqlSession getSqlSession(){
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
    // 测试方法，用于查询所有用户并打印到控制台
    @Test
    public void selectAllTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(user-> System.out.println(user));
    }

    // 测试方法，用于根据部门ID查询部门及其下的用户，并打印到控制台
    @Test
    public void findDeptUserTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        DeptVo vo = deptMapper.findDeptUser(2); // 假设2是部门ID
        System.out.println(vo);
    }

    // 测试方法，用于根据多个部门ID查询对应的部门及其下的用户，并打印到控制台
    @Test
    public void findDeptUsersTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Integer> ids = Arrays.asList(1, 2); // 部门ID列表
        List<DeptVo> vo = deptMapper.findDeptUsers(ids);
        for(DeptVo deptVo: vo){
            System.out.println(deptVo);
        }
    }

    // 测试方法，用于查询所有部门及其下的用户，并打印到控制台
    @Test
    public void findDeptUserAllTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<DeptVo> vo = deptMapper.findDeptUserAll();
        for(DeptVo deptVo: vo){
            System.out.println(deptVo);
        }
    }

    // 测试方法，用于根据用户ID查询用户及其所在的部门，并打印到控制台
    @Test
    public void findUserDeptTest(){
        SqlSession sqlSession=MyBatisDemo.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserVo vo= userMapper.findUserDept(2); // 假设2是用户ID
        System.out.println(vo);
    }

    // 测试方法，用于根据多个用户ID查询对应的用户及其所在的部门，并打印到控制台
    @Test
    public void findUsersDeptTest(){
        SqlSession sqlSession=MyBatisDemo.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = Arrays.asList(1, 2); // 用户ID列表
        List<UserVo> vo= userMapper.findUsersDept(ids);
        for (UserVo userVo : vo) {
            System.out.println(userVo);
        }
    }
    // 测试方法，用于查询所有用户及其所在的部门，并打印到控制台
    @Test
    public void findUserDeptAllTest(){
        SqlSession sqlSession=MyBatisDemo.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<UserVo> vo= userMapper.findUserDeptAll();
        for (UserVo userVo : vo) {
            System.out.println(userVo);
        }
    }
}
