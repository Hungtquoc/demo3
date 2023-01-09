package com.example.demo.reposiory;

import com.example.demo.model.JoinGroupUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.JoinRoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface JoinGroupRoleRespositoty extends JpaRepository<JoinRoleUser, Integer> {
    @Query("select new JoinRoleUser(j.id,j.roleId, j.userId) from JoinRoleUser j " +
            "where j.roleId = :id")
    List<JoinRoleUser> GetUserByRoleId(@Param("id") int id);

    @Query("select new JoinRoleUser(j.id,j.roleId, j.userId) from JoinRoleUser j " +
            "where j.userId = :id")
    List<JoinRoleUser> GetUserByUserId(@Param("id") int id);
}
