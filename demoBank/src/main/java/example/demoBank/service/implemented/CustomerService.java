package example.demoBank.service.implemented;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.demoBank.entity.Customer;
import example.demoBank.repository.CustomerRepository;
import example.demoBank.service.CustomerServiceUnimplemented;


@Service
public class CustomerService implements CustomerServiceUnimplemented{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public long count() {
		return customerRepository.count();
	}

	@Override
	public void delete(long ID) {
		customerRepository.deleteById(ID);
		
	}

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByID(long ID) {
		Optional<Customer> customer = customerRepository.findById(ID);
		if(customer.isPresent()) {
			return customer.get();
		}
		else return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public boolean exists(Customer customer) {
		return customerRepository.existsById(customer.getId());
	}

}
