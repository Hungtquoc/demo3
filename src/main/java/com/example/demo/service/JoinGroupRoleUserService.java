package com.example.demo.service;

import com.example.demo.model.JoinGroupRoleUser;

import java.util.List;

public interface JoinGroupRoleUserService {

    public JoinGroupRoleUser addNewUser(int userId, int groupRoleId) throws Exception;

    public List<JoinGroupRoleUser> getJoinGroupRoleUserById(int id);

    public String deletUser(int id);
}
