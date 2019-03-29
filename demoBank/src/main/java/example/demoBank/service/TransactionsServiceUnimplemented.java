package example.demoBank.service;

import java.util.List;

import example.demoBank.entity.Transaction;

public interface TransactionsServiceUnimplemented {

	long count();
	void delete(long ID);
	void deleteAll();
	void addTransaction(Transaction transactions);
	Transaction findByID(long ID);
	List<Transaction> findAllTransactions();
	boolean exists(Transaction transactions);
}
