// 
// Decompiled by Procyon v0.5.36
// 

package com.company.dao.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity1.Skill;
import com.company.entity1.User;
import com.company.entity1.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserSkillDaoImpl implements UserSkillDaoInter
{
    @PersistenceContext
    EntityManager em;
        @Override
    public List<UserSkill> getAllSkillByUserId(final int userId) {
        try{
       Query query =em.createQuery("Select us from UserSkill us where us.user.id=:uId",UserSkill.class);
       query.setParameter("uId", userId);
       List<UserSkill> list=query.getResultList();
       return list;
        } catch (Exception ex) {
            System.err.println(ex);
          return null;
        }finally{
            em.close();
        }
    }
    
     @Override
    public UserSkill getUserSkill(User user, Skill skill) {
         try{
       Query query =em.createQuery("Select us from UserSkill us where us.skill=:s and us.user=:u");
       query.setParameter("s",skill);
       query.setParameter("u",user);
       UserSkill us=(UserSkill) query.getResultList().get(0);
       return us;
        } catch (Exception ex) {
            System.err.println(ex);
          return null;
        }finally{
            em.close();
        }
         }
    
    @Override
    public boolean insertUserSkill(final UserSkill us) {
        try {
           em.persist(us);
           return true;
        }
        catch (Exception ex) {
            System.err.println(ex);
          return false;
        }
    }
    @Override
    public boolean insertUserSkillList(List<? extends UserSkill> userSkillList) {
       try{
            for (UserSkill us:userSkillList) {
                insertUserSkill(us);
            }
            return true;
        }
        catch (Exception ex) {
           ex.printStackTrace();
           return false;
        }
    }
    
    @Override
    public boolean updateUserPower(final int power, final int user_id, final int skill_id) {
        try {
         UserSkill us=getUserSkill(new User(user_id),new Skill(skill_id,null));
         em.merge(us);
         return true;
        }
        catch (Exception ex) {
            System.err.println(ex);
           return false;
        }
    }
    
    @Override
    public boolean removeUserSkill(final UserSkill userSkill) {
        try {
            UserSkill us=em.find(UserSkill.class,userSkill.getId());
            System.out.println(us.getId());
            em.remove(us);
            return true;
             }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeAllUserSkills(int userId) {
        try{
            for (UserSkill us:this.getAllSkillByUserId(userId)) {
                removeUserSkill(us);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
            }
        }
    
        @Override
    public boolean checkUserSkill(final int user_id, final int skill_id) {
        try {
         Query query =em.createQuery("Select COUNT(us.id)  from UserSkill us where us.user.id=:uId and us.skill.id=:sId");
         query.setParameter("uId", user_id);
         query.setParameter("sId", skill_id);
         Long count=(Long) query.getResultList().get(0);
         return count==0;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserSkill> turnToUserSkillList(int userId, String[] skillIds, String[] skillPercents) {
        List<UserSkill> userSkillList=new ArrayList<>();
        for (int i = 0; i < skillIds.length; i++) {
               if(skillPercents[i].contains("%") && !skillPercents[i].trim().equals("0%"))
            userSkillList.add(new UserSkill(null,new User(userId),
                    new Skill(Integer.parseInt(skillIds[i].trim()))
                    ,Integer.parseInt(skillPercents[i].replace("%","").trim())));
        }
        return userSkillList;
    }

}
