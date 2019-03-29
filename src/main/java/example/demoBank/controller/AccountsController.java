package example.demoBank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.dto.request.NewAccountRequest;
import example.demoBank.entity.Account;
import example.demoBank.entity.Customer;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.repository.CustomerRepository;
import example.demoBank.service.implemented.AccountsService;
import example.demoBank.service.implemented.CustomerService;
import example.demoBank.service.implemented.TransactionsService;

@RestController
public class AccountsController {

	private AccountsService accountsService;

	@Autowired
	public AccountsController(AccountsService accountsService) {
		try {
			this.accountsService = accountsService;
		} catch (Exception ignored) {

		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public List<Account> getAllAccounts() {
		return (List<Account>) accountsService.findAllAccounts();
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/accounts/new")
	@PostMapping("accounts/new")
	public void addAccount(@RequestBody NewAccountRequest newAccountRequest) {
		// Write integration test for this layer
		accountsService.addAccount(newAccountRequest);
	}

}
