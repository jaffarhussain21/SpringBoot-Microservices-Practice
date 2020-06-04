package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.dto.CustomerDTO;
import org.arpit.java2blog.model.Customer;

public interface CustomerService {
	
	public List<CustomerDTO> getAllCustomers();
	
	public CustomerDTO getCustomer(int id);

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);
}
