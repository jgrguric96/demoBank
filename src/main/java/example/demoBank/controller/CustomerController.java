package example.demoBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Customer;
import example.demoBank.service.implemented.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getAllCustomers(){
		return customerService.findAllEntities();
	}
}
