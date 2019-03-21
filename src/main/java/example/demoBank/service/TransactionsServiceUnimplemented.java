package example.demoBank.service;

import java.util.List;

import example.demoBank.entity.Transactions;

public interface TransactionsServiceUnimplemented {

	long count();
	void delete(long ID);
	void deleteAll();
	Transactions addTransaction(Transactions transactions);
	Transactions findByID(long ID);
	List<Transactions> findAllTransactions();
	boolean exists(Transactions transactions);
}
