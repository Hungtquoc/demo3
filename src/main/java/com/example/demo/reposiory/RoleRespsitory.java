package com.example.demo.reposiory;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRespsitory extends JpaRepository<Role, Integer> {
    @Query("select new Role(r.id, r.name, r.grouprole,r.status) from GroupRole gr join Role r " +
            "on r.grouprole = gr.id where gr.id = :id"
    )
    List<Role> getRoleBygrouprole(@Param("id") int id);
}
