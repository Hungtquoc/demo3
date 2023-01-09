package com.example.demo.service;

import com.example.demo.model.GroupRole;
import com.example.demo.model.GroupRoleDTO;
import com.example.demo.model.User;

import java.util.List;

public interface GroupRoleService {
    public GroupRole getGRById(int id);
    public GroupRoleDTO getAllGroupRole(Integer pageNo, Integer pageSize, String sortBy);
    public GroupRole disableGR(int id);
    public GroupRole updateGR(GroupRole gr);
    public GroupRole insertGR(GroupRole gr);
    public List<GroupRole> getAll();

}
