package com.example.demo.service.Impl;

import com.example.demo.model.Role;
import com.example.demo.model.RoleDTO;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.reposiory.RoleRespsitory;
import com.example.demo.reposiory.UserRepository;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRespsitory roleRespsitory;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Role getRoleById(int id) {
        Role role = roleRespsitory.findById(id).orElse(null);
        return role;
    }

    @Override
    public Role updateRole(Role r) {
        Role role = roleRespsitory.findById(r.getId()).orElse(null);
        role.setName(r.getName());
        role.setGrouprole(r.getGrouprole());
        role.setStatus(r.isStatus());
        return roleRespsitory.save(role);
    }

    @Override
    public Role addNewRole(Role r) {
        return roleRespsitory.save(r);
    }

    @Override
    public RoleDTO pagination(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Role> pagedResult = roleRespsitory.findAll(paging);

        if(pagedResult.hasContent()) {
            return new RoleDTO(pagedResult.getContent(), pagedResult.getTotalElements());
        } else {
            return new RoleDTO();
        }
    }

    @Override
    public Role disableRole(int id) {
        Role role = roleRespsitory.findById(id).orElse(null);
         if(role.isStatus()==true){
             role.setStatus(false);
         }else{
             role.setStatus(true);
         }
        return roleRespsitory.save(role);
    }

    @Override
    public List<Role> ListOfRole() {
        return roleRespsitory.findAll();
    }
    @Override
    public List<Role> ListRoleByGroupRoleID(int id){
        return roleRespsitory.getRoleBygrouprole(id);
    }

}
