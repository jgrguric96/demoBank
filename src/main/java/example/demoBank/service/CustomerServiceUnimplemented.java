package example.demoBank.service;

import java.util.List;

import example.demoBank.entity.Customer;

public interface CustomerServiceUnimplemented {
	
	long count();
	void delete(long ID);
	void deleteAll();
	Customer addCustomer(Customer customer);
	Customer findByID(long ID);
	List<Customer> findAllCustomers();
	boolean exists(Customer customer);
}
