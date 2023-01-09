package com.example.demo.service.Impl;

import com.example.demo.model.JoinGroupUser;
import com.example.demo.reposiory.JoinGroupUserRepository;
import com.example.demo.service.JoinGroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinGroupUserServiceImpl implements JoinGroupUserService {
    @Autowired
    JoinGroupUserRepository joinGroupUserRepository;

    @Override
    public List<JoinGroupUser> listOfUserInGroup(int id) {
        return joinGroupUserRepository.GetUserByUserId(id);
    }

    @Override
    public JoinGroupUser addNewUser(int userId, int groupId) throws Exception {
        JoinGroupUser groupUser = new JoinGroupUser();
        groupUser.setUserId(userId);
        groupUser.setGroupUserId(groupId);
        return joinGroupUserRepository.save(groupUser);
    }

    @Override
    public JoinGroupUser updateUser(JoinGroupUser joinGroupUser) {
        JoinGroupUser user = joinGroupUserRepository.findById(joinGroupUser.getId()).orElse(null);
        user.setUserId(joinGroupUser.getUserId());
        user.setGroupUserId(joinGroupUser.getGroupUserId());
        return joinGroupUserRepository.save(user);
    }

    @Override
    public List<JoinGroupUser> getJoinGroupUserById(int id) {
        return joinGroupUserRepository.GetUserByGUId(id);
    }

    @Override
    public JoinGroupUser getGroupUserbById(int id) {
        return joinGroupUserRepository.findById(id).orElse(null);
    }

    @Override
    public String deletUser(int id) {
        joinGroupUserRepository.deleteById(id);
        return "Da xoa thanh cong";
    }
}
