package com.example.demo.model;

import java.util.List;

public class UserDTO {
    private List<User> u;
    private long totalPage;

    public UserDTO(List<User> u, long totalPage) {
        this.u = u;
        this.totalPage = totalPage;
    }

    public UserDTO() {
    }

    public List<User> getU() {
        return u;
    }

    public void setU(List<User> u) {
        this.u = u;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}
