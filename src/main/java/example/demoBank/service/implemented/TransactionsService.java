package example.demoBank.service.implemented;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.demoBank.entity.Transaction;
import example.demoBank.entity.TransactionType;
import example.demoBank.service.TransactionsServiceUnimplemented;
import example.demoBank.repository.TransactionsRepository;


@Service
public class TransactionsService implements TransactionsServiceUnimplemented{

	
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private AccountsService accountService;
	
	@Override
	public long count() {
		return transactionsRepository.count();
		}

	@Override
	public void delete(long ID) {
		transactionsRepository.deleteById(ID);
		
	}

	@Override
	public void deleteAll() {
		transactionsRepository.deleteAll();
		
	}

	@Override
	public void addTransaction(Transaction transactions) {
		transactionsRepository.save(transactions);
		accountService.updateAccount(transactions);
	}

	@Override
	public Transaction findByID(long ID) {
		Optional<Transaction> transactions = transactionsRepository.findById(ID);
		if(transactions.isPresent()) 
			return transactions.get();
		else
			return null;
	}

	@Override
	public List<Transaction> findAllTransactions() {
		return (List<Transaction>) transactionsRepository.findAll();
	}

	@Override
	public boolean exists(Transaction transactions) {
		return transactionsRepository.existsById(transactions.getId());
	}

}
