package com.example.demo.service.Impl;

import com.example.demo.model.JoinGroupRoleUser;
import com.example.demo.model.JoinRoleUser;
import com.example.demo.reposiory.JoinGroupRoleUserRepository;
import com.example.demo.service.JoinGroupRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoinGroupRoleUserServiceImpl implements JoinGroupRoleUserService {
    @Autowired
    JoinGroupRoleUserRepository joinGroupRoleUserRepository;
    @Override
    public JoinGroupRoleUser addNewUser(int userId, int groupRoleId) throws Exception {
        JoinGroupRoleUser joinGroupRoleUser = new JoinGroupRoleUser();
        joinGroupRoleUser.setUserId(userId);
        joinGroupRoleUser.setGroupRoleId(groupRoleId);
        return joinGroupRoleUserRepository.save(joinGroupRoleUser);
    }

    @Override
    public List<JoinGroupRoleUser> getJoinGroupRoleUserById(int id) {
        return joinGroupRoleUserRepository.GetUserByGUId(id);
    }

    @Override
    public String deletUser(int id) {
         joinGroupRoleUserRepository.deleteById(id);
         return "Xoa thanh cong";
    }
}
