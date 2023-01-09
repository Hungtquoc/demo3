package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class JoinGroupRoleUser {
    @Id
    @GeneratedValue
    private int id;
    private int userId;

    private int groupRoleId;

    public JoinGroupRoleUser() {
    }

    public JoinGroupRoleUser(int id, int userId, int groupRoleId) {
        this.id = id;
        this.userId = userId;
        this.groupRoleId = groupRoleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(int groupRoleId) {
        this.groupRoleId = groupRoleId;
    }
}
