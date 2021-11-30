package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.util.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletContext;

@SpringBootApplication
public class Resumewebapp2Application  implements CommandLineRunner {

	@Autowired
	@Qualifier("userDao")
	UserDaoInter userDao;

	@Autowired
	private ServletContext context;

	public static void main(String[] args) {
			SpringApplication.run(Resumewebapp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String path=context.getRealPath("/");
		FileNameUtil.createFolder(path,"profilepictures");
	}

}
