package example.demoBank.service;

import java.util.List;

import example.demoBank.entity.Accounts;

public interface AccountsServiceUnimplemented {
	
	long count();
	void delete(long ID);
	void deleteAll();
	Accounts addAccount(Accounts accounts);
	Accounts findByID(long ID);
	Accounts findLatestAccount();
	List<Accounts> findAllAccounts();
	boolean exists(Accounts accounts);

}
