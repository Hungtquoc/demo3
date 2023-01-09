package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class JoinRoleUser {

    @Id
    @GeneratedValue
    private int id;
    private int roleId;
    private int userId;

    public JoinRoleUser(int id, int roleId, int userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public JoinRoleUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
