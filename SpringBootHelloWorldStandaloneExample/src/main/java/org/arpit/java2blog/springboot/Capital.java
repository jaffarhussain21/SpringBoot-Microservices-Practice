package org.arpit.java2blog.springboot;

import org.springframework.stereotype.Component;

@Component
public class Capital {
String capitalName = "Stockholm";

/**
 * @return the capitalName
 */
public String getCapitalName() {
	return capitalName;
}

/**
 * @param capitalName the capitalName to set
 */
public void setCapitalName(String capitalName) {
	this.capitalName = capitalName;
}
}
