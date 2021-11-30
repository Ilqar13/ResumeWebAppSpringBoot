
package com.company.dao.impl;

import com.company.dao.inter.UserDaoInter;
import com.company.entity1.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDaoInter
{

    @PersistenceContext
    private EntityManager em;

    public UserDaoImpl() {
    }

    @Override
    public User getById(final String userId) {
        try{
         return (User) em.find(User.class,Integer.parseInt(userId));
        }catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
    }


    @Override
    public User getByGmail(String userGmail) {
        String jpql ="Select u from User u where u.email=:email";
        Query query=em.createQuery("Select u from User u where u.email=:email",User.class);
        query.setParameter("email",userGmail);
        List<User> list=query.getResultList();
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }


    @Override
    public List<User> getAll(String name,String surname) {
        String jpql ="Select u from User u where 1=1";
        try {
            if(name!=null && !name.isEmpty()){
            jpql+=" and u.name=:name";
            
            }
            if(surname!=null  && !surname.isEmpty()){
            jpql+=" and u.surname=:surname";
            }
            
            Query query=em.createQuery(jpql, User.class);
            
            if(jpql.contains("name"))
                query.setParameter("name", name);
            
            if(jpql.contains("surname"))
                query.setParameter("surname", surname);
            return query.getResultList();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean updateUser(final User u) {
         try{
         em.merge(u);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeUser(final int id) {
        try{
           User user=em.find(User.class, id);
            em.remove(user);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean addUser(final User u) {
         try{
             em.persist(u);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
