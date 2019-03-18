package example.demoBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.demoBank.entity.Transactions;
import example.demoBank.repository.TransactionsRepository;

@RestController
public class TransactionsController {
	
	private TransactionsRepository transactionsRepository;
	
	@Autowired
	public TransactionsController(TransactionsRepository transactionsRepository) {
		this.transactionsRepository = transactionsRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/transactions")
	public List<Transactions> getAllTransactions(){
		return (List<Transactions>) transactionsRepository.findAll();
	}
}
