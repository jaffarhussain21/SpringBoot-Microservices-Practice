package org.arpit.java2blog.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.dto.CustomerDTO;
import org.arpit.java2blog.model.Customer;
import org.springframework.stereotype.Service;

@Service("customerService2")
public class CustomerServiceImpl2 implements CustomerService{
	Logger logger = Logger.getLogger(CustomerServiceImpl2.class);
	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		logger.info("************* CustomerServiceImpl2 line 23 *****************");
		return null;
	}

	@Override
	public CustomerDTO getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		logger.info("************* CustomerServiceImpl2 line 30 *****************");
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

}
