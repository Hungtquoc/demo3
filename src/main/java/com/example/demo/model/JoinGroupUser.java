package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class JoinGroupUser {
    @Id
    @GeneratedValue
    private int id;
    private int userId;

    private int groupUserId;

    public JoinGroupUser() {
    }

    public JoinGroupUser(int id, int userId, int groupUserId) {
        this.id = id;
        this.userId = userId;
        this.groupUserId = groupUserId;
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

    public int getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(int groupUserId) {
        this.groupUserId = groupUserId;
    }
}
