package example.demoBank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Accounts;
import example.demoBank.entity.Customer;
import example.demoBank.entity.NewAccount;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.repository.CustomerRepository;

@RestController
public class AccountsController {
	
	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public AccountsController(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
		this.accountsRepository = accountsRepository;
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public List<Accounts> getAllAccounts(){
		return (List<Accounts>) accountsRepository.findAll();
		}
	@RequestMapping(method = RequestMethod.POST, value = "/accounts/new")
	public void addAccount(@RequestBody NewAccount newAccount) {
		
		Accounts account = new Accounts();
		
		account.setInitialCredit(newAccount.getInitialCredit());
		account.setBalance(newAccount.getInitialCredit());
		account.setCustomer(customerRepository.findById(newAccount.getCustomerID()).orElse(null));
		
		try {
		accountsRepository.save(account);
		}
		catch(Exception e) {
			System.out.println("asshole");
			e.printStackTrace();
		}
		
	}
	
}
