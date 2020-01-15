package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Admin;

public interface IAdmin {

        String createAccount(Admin admin);

        String updateAccount(Admin admin);

        String deleteAccount(Admin admin);

        Admin findByUsername(String username);

        Admin findOne(String id);


}

