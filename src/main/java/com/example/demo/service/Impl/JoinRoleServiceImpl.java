package com.example.demo.service.Impl;

import com.example.demo.model.JoinRoleUser;
import com.example.demo.reposiory.JoinGroupRoleRespositoty;
import com.example.demo.service.JoinRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoinRoleServiceImpl implements JoinRoleUserService {
    @Autowired
    JoinGroupRoleRespositoty joinGroupRoleRespositoty;
    @Override
    public List<JoinRoleUser> listOfUserInRole() {
        return null;
    }

    @Override
    public JoinRoleUser addNewUser(int userId, int roleId) {
        JoinRoleUser user= new JoinRoleUser();
        user.setUserId(userId);
        user.setRoleId(roleId);
        return joinGroupRoleRespositoty.save(user);
    }

    @Override
    public JoinRoleUser updateUser(JoinRoleUser joinRoleUser) {
        return null;
    }

    @Override
    public List<JoinRoleUser> getJoinRoleUserById(int id) {
        return joinGroupRoleRespositoty.GetUserByRoleId(id);
    }

    @Override
    public JoinRoleUser getRoleUserbById(int id) {
        return null;
    }

    @Override
    public String deletUser(int id) {
        joinGroupRoleRespositoty.deleteById(id);
        return "Xóa Thành Công ";
    }

    @Override
    public List<JoinRoleUser> getListUserByUserId(int id) {
        return joinGroupRoleRespositoty.GetUserByUserId(id);
    }
}
