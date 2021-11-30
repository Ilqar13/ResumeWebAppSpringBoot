
package com.company.dao.inter;

import com.company.entity1.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDaoInter
{
    List<User> getAll(String name,String surname);
    
    User getById(final String userId);
    
    boolean addUser(final User user);
    
    boolean updateUser(final User user);
    
    boolean removeUser(final int user);
    
    User getByGmail(final String userGmail);
}
