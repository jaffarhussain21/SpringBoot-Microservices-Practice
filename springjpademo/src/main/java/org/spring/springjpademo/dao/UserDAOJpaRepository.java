package org.spring.springjpademo.dao;

import org.spring.springjpademo.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAOJpaRepository extends JpaRepository<UserTable, Long> {

	@Query("select u from UserTable u where u.name = ?1 ")
	public UserTable findByName(String name);

	@Query(value = "select * from User_Table u where u.role = ?1 ", nativeQuery = true)
	public UserTable findByRole(String role);
}
