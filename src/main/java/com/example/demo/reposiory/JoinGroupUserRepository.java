package com.example.demo.reposiory;

import com.example.demo.model.JoinGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinGroupUserRepository extends JpaRepository<JoinGroupUser, Integer> {
    @Query("select new JoinGroupUser(j.id,j.userId, j.groupUserId) from JoinGroupUser j " +
            "where j.groupUserId = :id")
    List<JoinGroupUser> GetUserByGUId(@Param("id") int id);

    @Query("select new JoinGroupUser(j.id,j.userId, j.groupUserId) from JoinGroupUser j " +
            "where j.userId = :id")
    List<JoinGroupUser> GetUserByUserId(@Param("id") int id);
}
