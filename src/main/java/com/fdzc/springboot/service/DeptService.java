package com.fdzc.springboot.service;

import com.fdzc.springboot.entity.Dept;
import com.fdzc.springboot.vo.DeptVo;

import java.util.List;

public interface DeptService {
    List<Dept> getAllDepts();
    Dept getDeptById(Integer id);
    Integer insertDept(Dept dept);
    Integer insertDepts(List<Dept> depts);
    Integer updateDeptById(Integer id, Dept dept);
    Integer deleteDeptById(Integer id);
    Integer deleteBatch(Integer[] deptIds);
    DeptVo findDeptUser(Integer id);
    List<DeptVo> findDeptUsers(List<Integer> ids);
    List<DeptVo> findDeptUserAll();
}