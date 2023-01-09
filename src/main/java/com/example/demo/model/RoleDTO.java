package com.example.demo.model;

import java.util.List;

public class RoleDTO {
    private List<Role> role;
    private long totalUnit;

    public RoleDTO() {
    }

    public RoleDTO(List<Role> role, long totalUnit) {
        this.role = role;
        this.totalUnit = totalUnit;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public long getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(long totalUnit) {
        this.totalUnit = totalUnit;
    }
}
