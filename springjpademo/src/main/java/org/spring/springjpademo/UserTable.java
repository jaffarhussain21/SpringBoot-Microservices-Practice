package org.spring.springjpademo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserTable {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	private Date dateOfBirth;

	public UserTable() {

	}

	public UserTable(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
