// 
// Decompiled by Procyon v0.5.36
// 

package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity1.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class SkillDaoImpl implements SkillDaoInter
{
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Skill> getAllSkill() {
     try{
     Query query =em.createQuery("Select s from Skill s");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }
    }

    @Override
    public List<String> getAllSkillNames() {
        try{
            Query query =em.createQuery("Select s.name from Skill s");
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Skill getById(final int userId) {
       try{
          return (Skill) em.find(Skill.class,userId);
       }catch(Exception ex){
           ex.printStackTrace();
           return null;
       }
    }
    
     @Override
    public String getSkillNameById(int id) {
        Query query =em.createQuery("Select s.name from Skill s where s.id=:id");
        query.setParameter("id", id);
        return (String) query.getResultList().get(0);
        }
    
    @Override
    public boolean updateSkill(final Skill skill) {
        boolean b = true;
        try {
            em.merge(skill);
        }
        catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }
    
    @Override
    public boolean insertSkill(final Skill skill) {
        try {
          em.persist(skill);
          return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public int getIdByName(final String name) {
        try {
            Query query =em.createQuery("Select s.id from Skill s where s.name=:name");
            query.setParameter("name",name);
            return (int) query.getResultList().get(0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    @Override
    public boolean removeSkill(final int id) {
        try {
            em.remove(em.find(Skill.class,id));
            return true;
                    }
        catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    @Override
    public Skill getByName(final String name) {
         try {
            Query query =em.createQuery("Select s from Skill s where s.name=:name");
            query.setParameter("name", name);
             return null;
        }catch (Exception ex){
             ex.printStackTrace();
             return null;
         }
    }
    
    @Override
    public long countSkill() {
       try {
            Query query =em.createQuery("Select COUNT(s.name) from Skill s");
            return (long) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return 0;
        }
    }
   
       @Override
      public boolean checkId(final int id) {
        try {
            Query query =em.createQuery("Select COUNT(s.name) from Skill s where s.id=:id");
            query.setParameter("id", id);
            if((Long)query.getResultList().get(0)==0){
                return true;
            }else{
                return false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
             return false;
        }
    }

    @Override
    public List<Skill> getAllSkillNotsignedForUser(int id) {
        try {
            Query query = em.createQuery("Select s from Skill s left join UserSkill us on s.id=us.skill.id where us.user.id!=:id or us.skill.id is null");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
