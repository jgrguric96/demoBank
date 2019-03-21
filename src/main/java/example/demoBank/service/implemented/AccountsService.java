package example.demoBank.service.implemented;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.demoBank.entity.Accounts;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.service.AccountsServiceUnimplemented;

@Service
public class AccountsService implements AccountsServiceUnimplemented{

	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Override
	public long count() {
		return accountsRepository.count();
	}

	@Override
	public void delete(long ID) {
		accountsRepository.deleteById(ID);
		
	}

	@Override
	public void deleteAll() {
		accountsRepository.deleteAll();
		
	}

	@Override
	public Accounts addAccount(Accounts accounts) {
		return accountsRepository.save(accounts);
	}

	@Override
	public Accounts findByID(long ID) {
		Optional<Accounts> account = accountsRepository.findById(ID);
		if(account.isPresent()) {
			return account.get();
		}
		else return null;
	}

	@Override
	public List<Accounts> findAllAccounts() {
		return (List<Accounts>) accountsRepository.findAll();
	}

	@Override
	public boolean exists(Accounts accounts) {
		return accountsRepository.existsById(accounts.getAccountID());
	}

	@Override
	public Accounts findLatestAccount() {
		List<Accounts> accounts = (List<Accounts>) accountsRepository.findAll();
		return accounts.get(accounts.size()-1);
	}

}
