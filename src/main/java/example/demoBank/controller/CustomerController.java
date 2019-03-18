package example.demoBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Customer;
import example.demoBank.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getAllCustomers(){
		return (List<Customer>) customerRepository.findAll();
	}	
}
