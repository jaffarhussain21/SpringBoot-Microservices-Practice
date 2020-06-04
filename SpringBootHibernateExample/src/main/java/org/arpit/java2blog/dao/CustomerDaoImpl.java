package org.arpit.java2blog.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.model.Customer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		logger.info("********* DAO: at line 25 ************");
		return customerList;
	}

	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(customer);
		session.update(customer);
	}

	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}
