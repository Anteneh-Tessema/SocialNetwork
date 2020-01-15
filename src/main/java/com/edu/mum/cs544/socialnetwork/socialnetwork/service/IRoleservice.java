package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Role;

import java.util.List;

public interface IRoleservice {
    List<Role> findAll();

    Role get(Long id);
}
