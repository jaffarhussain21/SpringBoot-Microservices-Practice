package org.arpit.java2blog.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Country {

	@Value("${countryName}")
	private String countryName;

	private Capital capital;

	public Country() {

	}

	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the capital
	 */
	public Capital getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
}

/**
 * 1. How to configure MQSQL database. 2. Hibernate Framework 3 Springboot
 * Hibernate Application. 4. Service & DAO layers. 5. DTO's
 * 
 * JSR - JPA. ORM - Apache, Oracle Apache - Hibernate using JPA Oracle - iBatis
 * using JPA
 * 
 */
