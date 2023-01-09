package com.example.demo.reposiory;

import com.example.demo.model.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRespository extends JpaRepository<GroupUser, Integer> {
}
