 
 

package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity1.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDaoInter
{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAllCountry() {
    try{
     Query query =em.createQuery("Select c from Country c");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }finally{
          em.close();
     }
    }

    @Override
    public List<String> getAllCountryNames() {
        try{
            Query query =em.createQuery("Select c.name from Country c");
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }finally{
            em.close();
        }
    }
    
    @Override
    public Integer getIdByName(final String name) {
        try {
            Query query =em.createQuery("Select c.id from Country c where c.name=:name");
               query.setParameter("name", name);
            return (Integer) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return null;
        }finally{
             em.close();
         }
    }
    
    @Override
    public Integer getIdByNationality(final String nationality) {
         try {
            Query query =em.createQuery("Select c.id from Country c where c.nationality=:nationality");
               query.setParameter("nationality",nationality);
            return (Integer) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return null;
        }finally{
             em.close();
         }
           }
}
