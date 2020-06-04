package org.spring.springjpademo.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springjpademo.UserTable;
import org.spring.springjpademo.dao.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

	@Autowired
	UserServiceDAO userServiceDAO;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		long id = userServiceDAO.insert(new UserTable("ABC", "Role1"));
		logger.info("Logging Id!" + id);
	}

}
