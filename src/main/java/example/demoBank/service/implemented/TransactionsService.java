package example.demoBank.service.implemented;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.demoBank.entity.Transactions;
import example.demoBank.service.TransactionsServiceUnimplemented;
import example.demoBank.repository.TransactionsRepository;


@Service
public class TransactionsService implements TransactionsServiceUnimplemented{

	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
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
	public Transactions addTransaction(Transactions transactions) {
		return transactionsRepository.save(transactions);
	}

	@Override
	public Transactions findByID(long ID) {
		Optional<Transactions> transactions = transactionsRepository.findById(ID);
		if(transactions.isPresent()) 
			return transactions.get();
		else
			return null;
	}

	@Override
	public List<Transactions> findAllTransactions() {
		return (List<Transactions>) transactionsRepository.findAll();
	}

	@Override
	public boolean exists(Transactions transactions) {
		return transactionsRepository.existsById(transactions.getTransactionID());
	}

}
