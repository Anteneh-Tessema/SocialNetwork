package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.AdminDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Admin;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IAdmin;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class AdminService implements IAdmin{

    @Autowired
    private AdminDao adminDao;

    @Override
    public String createAccount(Admin admin) {
        try {
            adminDao.create(admin);
            return Messages.save;
        } catch (Exception e) {
            e.printStackTrace();
            return Messages.expectation;
        }
    }

    @Override
    public String updateAccount(Admin admin) {
        try{
            adminDao.update(admin);
            return Messages.update;
        }catch (Exception e) {
            return Messages.expectation;
        }
    }

    @Override
    public String deleteAccount(Admin admin) {
        try {
            admin.setDeleted(true);
            adminDao.update(admin);
            return Messages.delete;
        } catch (Exception e) {
            return Messages.expectation;
        }
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDao.allAdmin().stream().filter(x -> x.getEmail().equals(username)).findAny().orElse(null);
    }

    @Override
    public Admin findOne(String id) {
        return adminDao.findOne(id);
    }
}
