package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.Impl.RoleRepository;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Role;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleservice {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role get(Long id) {
        return roleRepository.findById(id);
    }
}
