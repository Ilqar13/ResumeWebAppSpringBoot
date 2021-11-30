package com.company;

import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity1.Country;
import com.company.entity1.Skill;
import com.company.entity1.User;
import com.company.entity1.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication  /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

//	@Autowired
//	UserDaoInter userDaoInter;
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(userDaoInter.getById("6"));
//	}
}



