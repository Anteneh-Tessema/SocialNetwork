package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AdminDao extends GenericDao<Admin> {
    public List<Admin> allAdmin() {
        return allObejcts().stream().filter(x -> !x.isDeleted())
                .collect(Collectors.toList());
    }
}
