package org.arpit.java2blog.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.dto.CustomerDTO;
import org.arpit.java2blog.model.Customer;
import org.arpit.java2blog.service.CustomerService;
import org.arpit.java2blog.service.CustomerServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	@Qualifier("customerService1")
	CustomerService customerService1;
	
	@Autowired
	@Qualifier("customerService2")
	CustomerService customerService2;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllCustomers(Model model) {
		logger.info("********* at line 26 ************");
		List<CustomerDTO> listOfCustomers = customerService1.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		logger.info("********* at line 30 ************");
		return "customerDetails";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CustomerDTO getCustomerById(@PathVariable int id) {
		return customerService1.getCustomer(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		if (customer.getId() == 0) {
			customerService1.addCustomer(customer);
		} else {
			customerService1.updateCustomer(customer);
		}

		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService1.getCustomer(id));
		model.addAttribute("listOfCustomers", this.customerService1.getAllCustomers());
		return "customerDetails";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService1.deleteCustomer(id);
		return "redirect:/getAllCustomers";

	}
}
