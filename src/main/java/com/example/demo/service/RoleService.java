package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.RoleDTO;
import com.example.demo.model.User;

import java.util.List;


public interface RoleService {
    public Role getRoleById(int id);

    public Role updateRole(Role r);

    public Role addNewRole(Role r);

    public RoleDTO pagination(Integer pageNo, Integer pageSize, String sortBy);

    public Role disableRole(int id);

    public List<Role> ListOfRole();

    public List<Role> ListRoleByGroupRoleID(int id);
}
