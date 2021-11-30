
package com.company.service.impl;

import com.company.dao.inter.UserDaoInter;
import com.company.entity1.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Scope("prototype")
@Transactional
public class UserServiceImpl implements UserServiceInter
{
    @Autowired
    private UserDaoInter userDao;

    @Override
    public User getById(final String userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByGmail(String userGmail) {
        return userDao.getByGmail(userGmail);
    }

    @Override
    public List<User> getAll(String name,String surname) {
        return userDao.getAll(name,surname);
    }
    
    @Override
    public boolean updateUser(final User u) {
       return  userDao.updateUser(u);
    }
    
    @Override
    public boolean removeUser(final int id) {
        return userDao.removeUser(id);
    }
    
    @Override
    public boolean addUser(final User u) {
        return userDao.addUser(u);
    }

}
