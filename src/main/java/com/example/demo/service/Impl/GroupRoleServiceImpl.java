package com.example.demo.service.Impl;

import com.example.demo.model.*;
import com.example.demo.reposiory.GroupRoleRespsitory;
import com.example.demo.service.GroupRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {


    @Autowired
    private GroupRoleRespsitory groupRoleRespsitory;

    @Override
    public GroupRole getGRById(int id) {
        GroupRole groupRole = groupRoleRespsitory.findById(id).orElse(null);
        return groupRole;
    }

    @Override
    public GroupRoleDTO getAllGroupRole(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<GroupRole> pagedResult = groupRoleRespsitory.findAll(paging);

        if (pagedResult.hasContent()) {
            return new GroupRoleDTO(pagedResult.getContent(), pagedResult.getTotalElements());
        } else {
            return new GroupRoleDTO();
        }
    }

    @Override
    public GroupRole disableGR(int id) {
        GroupRole groupRole = groupRoleRespsitory.findById(id).orElse(null);
        if (groupRole.getStatus() == true) {
            groupRole.setStatus(false);
        } else {
            groupRole.setStatus(true);
        }
        return groupRoleRespsitory.save(groupRole);
    }

    @Override
    public GroupRole updateGR(GroupRole gr) {
        GroupRole groupRole = groupRoleRespsitory.findById(gr.getId()).orElse(null);
        groupRole.setName(gr.getName());
        groupRole.setStatus(gr.getStatus());
        return groupRoleRespsitory.save(groupRole);
    }

    @Override
    public GroupRole insertGR(GroupRole gr) {
        return groupRoleRespsitory.save(gr);
    }

    @Override
    public List<GroupRole> getAll() {
        return groupRoleRespsitory.findAll();
    }
}
