package com.example.demo.service;

import com.example.demo.model.JoinRoleUser;

import java.util.List;

public interface JoinRoleUserService {
    public List<JoinRoleUser> listOfUserInRole();
    public JoinRoleUser addNewUser(int userId, int roleId) throws Exception;
    public JoinRoleUser updateUser(JoinRoleUser joinRoleUser);
    public List<JoinRoleUser> getJoinRoleUserById(int id);
    public JoinRoleUser getRoleUserbById(int id);

    public String deletUser(int id);

    public List<JoinRoleUser> getListUserByUserId(int id);
}
