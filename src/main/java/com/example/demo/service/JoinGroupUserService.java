package com.example.demo.service;

import com.example.demo.model.JoinGroupUser;
import java.util.List;
public interface JoinGroupUserService {
    public List<JoinGroupUser> listOfUserInGroup(int id);
    public JoinGroupUser addNewUser(int userId, int groupId) throws Exception;
    public JoinGroupUser updateUser(JoinGroupUser joinGroupUser);
    public List<JoinGroupUser> getJoinGroupUserById(int id);
    public JoinGroupUser getGroupUserbById(int id);

    public String deletUser(int id);

}
