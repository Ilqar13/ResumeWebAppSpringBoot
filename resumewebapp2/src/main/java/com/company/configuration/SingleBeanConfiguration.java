package com.company.configuration;

import com.company.dao.inter.*;
import com.company.entity1.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SingleBeanConfiguration {

    @Autowired
    private SkillDaoInter skillDao;
    @Autowired
    private CountryDaoInter countryDao;
    @Autowired
    private UserDaoInter userDao;
    @Autowired
    private EmploymentHistoryDaoInter employmentHistoryDao;
    @Autowired
    private UserSkillDaoInter userSkillDao;

    @Bean("userDao")
    public UserDaoInter getUserDao(){
        return  userDao;
    }

    @Bean("userSkillDao")
    public UserSkillDaoInter getUserSkillDao(){
        return  userSkillDao;
    }

    @Bean("skillDao")
    public SkillDaoInter getSkillDao(){
        return  skillDao;
    }

    @Bean("employmentHistoryDao")
    public EmploymentHistoryDaoInter getEmploymentHistoryDao(){
        return  employmentHistoryDao;
    }

    @Bean("countryDao")
    public CountryDaoInter getCountryDao(){
        return  countryDao;
    }

    @Bean("countries")
    public List<Country> getCountry(){
        return countryDao.getAllCountry();
    }

}
