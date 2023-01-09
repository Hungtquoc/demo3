package com.example.demo.model;

import java.util.List;

public class GroupUserDTO {
    private List<GroupUser> groupUsers;
    private Long totalunit;

    public GroupUserDTO() {
    }

    public GroupUserDTO(List<GroupUser> groupUsers, Long totalunit) {
        this.groupUsers = groupUsers;
        this.totalunit = totalunit;
    }

    public List<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<GroupUser> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Long getTotalunit() {
        return totalunit;
    }

    public void setTotalunit(Long totalunit) {
        this.totalunit = totalunit;
    }
}
