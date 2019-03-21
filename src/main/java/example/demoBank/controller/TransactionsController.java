package example.demoBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Accounts;
import example.demoBank.entity.Transactions;
import example.demoBank.service.implemented.TransactionsService;

@RestController
public class TransactionsController {
	
	private TransactionsService transactionsService;
	
	@Autowired
	public TransactionsController(TransactionsService transactionsService) {
		this.transactionsService = transactionsService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/transactions")
	public List<Transactions> getAllTransactions(){
		return (List<Transactions>) transactionsService.findAllTransactions();
	}
	
	public void addFirstTransaction(Accounts account)
	{
		Transactions transaction = new Transactions();
		
		transaction.setAmmount(account.getBalance());
		transaction.setAccounts(account);
		
		transactionsService.addTransaction(transaction);
	}
}
