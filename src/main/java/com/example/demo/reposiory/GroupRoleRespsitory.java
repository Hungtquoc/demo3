package com.example.demo.reposiory;

import com.example.demo.model.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRoleRespsitory  extends JpaRepository<GroupRole, Integer> {

}
