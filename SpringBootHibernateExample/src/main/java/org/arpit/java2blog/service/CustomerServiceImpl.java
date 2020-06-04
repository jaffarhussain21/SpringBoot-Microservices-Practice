package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.arpit.java2blog.dao.CustomerDao;
import org.arpit.java2blog.dto.CustomerDTO;
import org.arpit.java2blog.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("customerService1")
public class CustomerServiceImpl implements CustomerService {
	Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerDao customerDao;

	@Transactional
	public List<CustomerDTO> getAllCustomers() {
		logger.info("********* Service : at line 23 ************");
		return copyProperties(customerDao.getAllCustomers());
	}

	@Transactional
	public CustomerDTO getCustomer(int id) {
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customerDao.getCustomer(id), customerDTO);
		return customerDTO;
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

	public List<CustomerDTO> copyProperties(List<Customer> customerList) {
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		for (Customer customer : customerList) {
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO);
			customerDTOList.add(customerDTO);
		}
		return customerDTOList;
	}

}
