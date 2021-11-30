
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity1.EmploymentHistory;
import com.company.entity1.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter
{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
     try{
     Query query =em.createQuery("Select eh from EmploymentHistory eh");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }finally{
          em.close();
    }
    }
    
    @Override
    public EmploymentHistory getEmploymentHistoryByUserId(final int userId) {
       
            try{
         return (EmploymentHistory) em.find(EmploymentHistory.class,userId);
        }catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean updateEmploymentHistory(final EmploymentHistory eh) throws Exception {
       try{
         em.merge(eh);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int userId) {
       try{
         em.remove(em.find(EmploymentHistory.class,userId));
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory employmentHistory) {
         try{
         em.persist(employmentHistory);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         }
    
    
}
