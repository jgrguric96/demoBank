package example.demoBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Account;
import example.demoBank.entity.Transaction;
import example.demoBank.service.implemented.TransactionsService;

@RestController
public class TransactionsController {
	
	private TransactionsService transactionsService;
	
	@Autowired
	public TransactionsController(TransactionsService transactionsService) {
		this.transactionsService = transactionsService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/transactions")
	public List<Transaction> getAllTransactions(){
		return (List<Transaction>) transactionsService.findAllEntities();
	}
	
	public void addFirstTransaction(Account account)
	{
		Transaction transaction = new Transaction();
		
		transaction.setAmmount(account.getBalance());
		transaction.setAccount(account);
		
		transactionsService.addNewEntity(transaction);
	}
}
