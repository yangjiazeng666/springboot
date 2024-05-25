package com.fdzc.springboot.vo;

import com.fdzc.springboot.entity.User;

import java.util.List;

public class DeptVo {
    private int id;
    private String deptName;
    private String description;
    private String address;
    List<User> users;

    public DeptVo() {
    }

    public DeptVo(int id, String deptName, String description, String address, List<User> users) {
        this.id = id;
        this.deptName = deptName;
        this.description = description;
        this.address = address;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users +
                '}';
    }
}
