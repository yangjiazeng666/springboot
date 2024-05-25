package com.fdzc.springboot.service;

import com.fdzc.springboot.entity.Dept;
import com.fdzc.springboot.mapper.DeptMapper;
import com.fdzc.springboot.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> getAllDepts() {
        return deptMapper.selectAll();
    }
    public Dept getDeptById(Integer id) {
        return deptMapper.selectById(id);
    }
    public Integer insertDept(Dept dept) {
        return deptMapper.insert(dept);
    }
    public Integer insertDepts(List<Dept> depts){
        return deptMapper.insertBatch(depts);
    }
    public Integer updateDeptById(Integer id, Dept dept) {
        return deptMapper.update(id, dept);
    }
    public Integer deleteDeptById(Integer id) {
        return deptMapper.delete(id);
    }
    public Integer deleteBatch(Integer[] deptIds){
        return deptMapper.deleteBatch(deptIds);
    }
    public DeptVo findDeptUser(Integer id){
        return deptMapper.findDeptUser(id);
    }
    public List<DeptVo> findDeptUsers(List<Integer> ids){
        return deptMapper.findDeptUsers(ids);
    }
    public List<DeptVo> findDeptUserAll(){
        return deptMapper.findDeptUserAll();
    }
}

