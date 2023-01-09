package com.example.demo.reposiory;

import com.example.demo.model.JoinGroupRoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinGroupRoleUserRepository extends JpaRepository<JoinGroupRoleUser, Integer> {
    @Query("select new JoinGroupRoleUser (j.id,j.userId, j.groupRoleId) from JoinGroupRoleUser j " +
            "where j.groupRoleId = :id")
    List<JoinGroupRoleUser> GetUserByGUId(@Param("id") int id);
}
