package com.example.demo.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.io.IOException;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private int role_id;
    private boolean status;
    private int group_user_id;
    private int group_role_id;
    public User() {
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role_id;
    }

    public void setRole(int role) {
        this.role_id = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getGroupUser() {
        return group_user_id;
    }

    public void setGroupUser(int groupUser) {
        this.group_user_id = groupUser;
    }

    public int getGroup_role_id() {
        return group_role_id;
    }

    public void setGroup_role_id(int group_role_id) {
        this.group_role_id = group_role_id;
    }
}
