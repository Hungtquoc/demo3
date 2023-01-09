package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;

public interface GroupUserService {

    public GroupUser getGUById(int id);
    public GroupUserDTO getAllGroupUser(Integer pageNo, Integer pageSize, String sortBy);
    public GroupUser disableGU(int id);
    public GroupUser updateGU(GroupUser gr);
    public GroupUser insertGU(GroupUser gr);
    public List<GroupUser> ListOfGR();
}
