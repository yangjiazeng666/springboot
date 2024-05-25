package com.fdzc.springboot.controller;

import com.fdzc.springboot.entity.Dept;
import com.fdzc.springboot.service.DeptService;
import com.fdzc.springboot.vo.DeptVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    private final Logger logger = Logger.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    // 查询所有部门信息
    @GetMapping("/findDeptAll")
    public List<Dept> getAllDepts() {
        return deptService.getAllDepts();
    }

    // 根据单个ID查询部门信息
    @GetMapping("/{id}")
    public Dept getDeptById(@PathVariable Integer id) {
        logger.info(id.toString());
        return deptService.getDeptById(id);
    }

    // 添加新部门
    @PostMapping("/insertDept")
    public String addDept(@RequestBody Dept dept) {
        try {
            logger.info(dept.toString());
            int count=deptService.insertDept(dept);
            return "成功添加了"+count+"条部门信息";
        }catch (RuntimeException e){
            return "添加失败: " + e.getMessage();
        }
    }
    //批量添加新部门
    @PostMapping("/insertBatch")
    public String addUsers(@RequestBody List<Dept> depts) {
        try {
            logger.info(depts.toString());
            int count=deptService.insertDepts(depts);
            return "成功添加了"+count+"条部门信息";
        }catch (RuntimeException e){
            return "添加失败: " + e.getMessage();
        }
    }

    // 根据ID更新部门信息
    @PutMapping("/{id}")
    public String updateDeptById(@PathVariable Integer id, @RequestBody Dept dept) {
        try {
            logger.info(dept.toString());
            int count=deptService.updateDeptById(id,dept);
            return "成功更新了"+count+"条部门信息";
        }catch (RuntimeException e){
            return "更新失败: " + e.getMessage();
        }
    }

    // 根据ID删除部门信息
    @DeleteMapping("/{id}")
    public String deleteDeptById(@PathVariable Integer id) {
        try {
            logger.info(id.toString());
            int count=deptService.deleteDeptById(id);
            return "成功删除了"+count+"条部门信息";
        }catch (RuntimeException e){
            return "删除失败: " + e.getMessage();
        }
    }
    //批量删除部门信息
    @DeleteMapping("deleteBatch")
    public String deleteUsers(@RequestBody Integer[] deptIds) {
        try {
            logger.info(Arrays.toString(deptIds));
            int count=deptService.deleteBatch(deptIds);
            return "成功删除了"+count+"条部门信息";
        }catch (RuntimeException e){
            return "删除失败: " + e.getMessage();
        }
    }

    //根据单个id查找部门里的用户信息
    @GetMapping("/findDeptUser/{id}")
    public DeptVo findDeptUser(@PathVariable Integer id){
        logger.info(id.toString());
        return deptService.findDeptUser(id);
    }
    //根据多个id查找部门里的用户信息
    @PostMapping("/findDeptUsers")
    public List<DeptVo> findDeptUsers(@RequestBody List<Integer> ids){
        logger.info(ids.toString());
        return deptService.findDeptUsers(ids);
    }
    //查找所有部门里的用户
    @GetMapping("/findDeptUserAll")
    public List<DeptVo> findDeptUserAll(){
        return deptService.findDeptUserAll();
    }
}