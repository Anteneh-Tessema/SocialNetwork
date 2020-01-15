package com.edu.mum.cs544.socialnetwork.socialnetwork.dao.Impl;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRole(String role);

    List<Role> findAll();

}
