package com.example.demo.service.Impl;

import com.example.demo.model.*;
import com.example.demo.reposiory.GroupRoleRespsitory;
import com.example.demo.reposiory.GroupUserRespository;
import com.example.demo.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupUserServiceImpl implements GroupUserService {
    @Autowired
    private GroupUserRespository groupUserRespository;

    @Override
    public GroupUser getGUById(int id) {
        GroupUser groupUser = groupUserRespository.findById(id).orElse(null);
        return groupUser;
    }

    @Override
    public GroupUserDTO getAllGroupUser(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<GroupUser> pagedResult = groupUserRespository.findAll(paging);
        if (pagedResult.hasContent()) {
            return new GroupUserDTO(pagedResult.getContent(), pagedResult.getTotalElements());
        } else {
            return new GroupUserDTO();
        }
    }

    @Override
    public GroupUser disableGU(int id) {
        GroupUser groupUser = groupUserRespository.findById(id).orElse(null);
        if (groupUser.isStatus() == true) {
            groupUser.setStatus(false);
        } else {
            groupUser.setStatus(true);
        }
        return groupUserRespository.save(groupUser);
    }

    @Override
    public GroupUser updateGU(GroupUser gr) {
        GroupUser groupUser = groupUserRespository.findById(gr.getId()).orElse(null);
        groupUser.setName(gr.getName());
        groupUser.setStatus(gr.isStatus());
        return groupUserRespository.save(groupUser);
    }

    @Override
    public GroupUser insertGU(GroupUser gr) {
        return groupUserRespository.save(gr);
    }

    @Override
    public List<GroupUser> ListOfGR() {
        return groupUserRespository.findAll();
    }

}
