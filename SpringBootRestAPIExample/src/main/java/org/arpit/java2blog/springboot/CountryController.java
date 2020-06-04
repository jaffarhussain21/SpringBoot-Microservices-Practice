
package org.arpit.java2blog.springboot;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.springboot.bean.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	Logger logger = Logger.getLogger(CountryController.class);
	/**
	 * //CRUD - Create : Read : Update : Delete // Create - POST / PUT: Read : GET,
	 * Update : POST / PUT, Delete : DELETE
	 */

	List<Country> listOfCountries;

	// @RequestMapping(value = "/countries",method= RequestMethod.GET, headers =
	// "Accept=application/json")
	@GetMapping(value = "/countries", headers = "Accept=application/json")
	public ResponseEntity getCountries() {
		listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();

		try {
			String s = null;
			System.out.println(s.equals("A"));
			return new ResponseEntity<Country>((Country) listOfCountries.get(0), HttpStatus.PROCESSING);
		} catch (Exception e) {
			System.out.println(e.getCause());
			return new ResponseEntity("Error Occurred !", HttpStatus.BAD_REQUEST);
		}
		// return listOfCountries;
	}

	// @RequestMapping(value = "/countries",method= RequestMethod.GET, headers =
	// "Accept=application/json")
	/*
	 * @GetMapping(value = "/countries", headers = "Accept=application/json") public
	 * List<Country> getCountries() { listOfCountries = new ArrayList<Country>();
	 * listOfCountries = createCountryList(); //return new
	 * ResponseEntity<Country>((Country) listOfCountries.get(0),
	 * HttpStatus.ACCEPTED); return listOfCountries; }
	 */

	@GetMapping(value = "/countries/{id}", headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();

		for (Country country : listOfCountries) {
			if (country.getId() == id)
				return country;
		}
		return null;
	}

	@PostMapping("/addCountry")
	public void addCountry(@RequestBody Country country) {
		logger.info("***************** Country Added ************" + country);
		listOfCountries.add(country);
		logger.info("***************** Country Added ************" + listOfCountries);
	}

// Utility method to create country list.
	public List<Country> createCountryList() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
		return listOfCountries;
	}
}
