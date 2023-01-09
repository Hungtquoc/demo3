package com.example.demo.model;

import java.util.List;

public class GroupRoleDTO {
    private List<GroupRole> groupRoleList;
    private long totalunit;

    public GroupRoleDTO(List<GroupRole> groupRoleList, long totalunit) {
        this.groupRoleList = groupRoleList;
        this.totalunit = totalunit;
    }

    public GroupRoleDTO() {
    }

    public List<GroupRole> getGroupRoleList() {
        return groupRoleList;
    }

    public void setGroupRoleList(List<GroupRole> groupRoleList) {
        this.groupRoleList = groupRoleList;
    }

    public long getTotalunit() {
        return totalunit;
    }

    public void setTotalunit(long totalunit) {
        this.totalunit = totalunit;
    }

}
