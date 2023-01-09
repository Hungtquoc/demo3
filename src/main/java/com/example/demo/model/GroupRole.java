package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GroupRole {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    private boolean status;
    public GroupRole() {
    }

    public GroupRole(int grid, String grname, boolean grstatus) {
        this.id = grid;
        this.name = grname;
        this.status = grstatus;
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

    public void setName(String grname) {
        this.name = grname;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean grstatus) {
        this.status = grstatus;
    }
}
