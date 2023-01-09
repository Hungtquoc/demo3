package com.example.demo.model;

import jakarta.persistence.*;
import com.example.demo.model.GroupRole;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int grouprole;
    private boolean status;

    public Role() {
    }

    public Role(int id, String name, int grouprole, boolean status) {
        this.id = id;
        this.name = name;
        this.grouprole = grouprole;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrouprole() {
        return grouprole;
    }

    public void setGrouprole(int grouprole) {
        this.grouprole = grouprole;
    }
}
