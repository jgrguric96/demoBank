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
import example.demoBank.service.implemented.AccountsService;
import example.demoBank.service.implemented.CustomerService;
import example.demoBank.service.implemented.TransactionsService;

@RestController
public class AccountsController {
	
	private AccountsService accountsService;
	private CustomerController customerController;
	private TransactionsController transactionsController;
	
	@Autowired
	public AccountsController(AccountsService accountsService, CustomerController customerController, TransactionsController transactionsController) {
		this.accountsService = accountsService;
		this.customerController = customerController;
		this.transactionsController = transactionsController;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public List<Accounts> getAllAccounts(){
		return (List<Accounts>) accountsService.findAllAccounts();
		}
	@RequestMapping(method = RequestMethod.POST, value = "/accounts/new")
	public void addAccount(@RequestBody NewAccount newAccount) {
		
		Accounts account = new Accounts();
		
		account.setInitialCredit(newAccount.getInitialCredit());
		account.setBalance(newAccount.getInitialCredit());
		account.setCustomer(customerController.getCustomerObject(newAccount.getCustomerID()));
		
		try {
		accountsService.addAccount(account);
		transactionsController.addFirstTransaction(accountsService.findLatestAccount());
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
