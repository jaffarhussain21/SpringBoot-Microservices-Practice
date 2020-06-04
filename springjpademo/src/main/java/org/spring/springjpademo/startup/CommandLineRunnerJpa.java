package org.spring.springjpademo.startup;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springjpademo.UserTable;
import org.spring.springjpademo.dao.UserDAOJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerJpa implements org.springframework.boot.CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(CommandLineRunnerJpa.class);

	@Autowired
	UserDAOJpaRepository userDAOJpaRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserTable user = userDAOJpaRepository.save(new UserTable("PQR", "Role2"));
		logger.info("Logging using JPA Id Save! " + user.getId());

		Optional<UserTable> userById = userDAOJpaRepository.findById(1l);
		logger.info("Logging retrieve by Id! " + userById.toString());

		List<UserTable> allUsers = userDAOJpaRepository.findAll();
		logger.info("Logging findAll! " + allUsers.toString());
	
		UserTable userByName = userDAOJpaRepository.findByName("PQR");
		logger.info("Logging Native Query! " + userByName.toString());
		
		UserTable userByRole = userDAOJpaRepository.findByRole("Role1");
		logger.info("Logging Pure Native Query! " + userByRole.toString());

	}

}
