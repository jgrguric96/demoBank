package example.demoBank.init;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import example.demoBank.entity.Accounts;
import example.demoBank.entity.Customer;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.repository.CustomerRepository;

@Component
public class DataInit implements ApplicationRunner{
	
	private CustomerRepository customerRepository;
	private AccountsRepository accountsRepository;
	
	@Autowired
	public DataInit(CustomerRepository customerRepository, AccountsRepository accountsRepository)
	{
		this.customerRepository = customerRepository;
		this.accountsRepository = accountsRepository;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		long count = customerRepository.count();
		
		if(count == 0) {
			Customer c1 = new Customer();
			
			c1.setName("Steve");
			c1.setSurname("Desni");
			customerRepository.save(c1);
			
			Accounts a1 = new Accounts();
			
			a1.setBalance(BigDecimal.valueOf(123456.78));
			a1.setInitialCredit(BigDecimal.valueOf(200000.00));
			a1.setCustomer(c1);
			accountsRepository.save(a1);
		}

	}

}
