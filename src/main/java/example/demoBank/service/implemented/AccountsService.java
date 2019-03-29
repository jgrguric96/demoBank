package example.demoBank.service.implemented;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.demoBank.dto.request.NewAccountRequest;
import example.demoBank.entity.Account;
import example.demoBank.entity.Customer;
import example.demoBank.entity.Transaction;
import example.demoBank.entity.TransactionType;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.service.AccountsServiceUnimplemented;

@Service
public class AccountsService {

	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TransactionsService transactionService;
	
	
	public long count() {
		return accountsRepository.count();
	}

	
	public void delete(long ID) {
		accountsRepository.deleteById(ID);
		
	}

	
	public void deleteAll() {
		accountsRepository.deleteAll();
		
	}

	
	@Transactional
	public void addAccount(NewAccountRequest newAccountRequest) {
		// Unit test for this method
		Account account = new Account();
		Transaction transaction = new Transaction();
		Customer customer = customerService.findByID(newAccountRequest.getCustomerID());
		Date now = new Date();
		
		account.setInitialCredit(newAccountRequest.getInitialCredit());
		account.setBalance(BigDecimal.valueOf(0));
		account.setCreationDate(now);
		account.setCustomer(customer);
		accountsRepository.save(account);
		
		transaction.setAmmount(newAccountRequest.getInitialCredit());
		transaction.setTransactionType(TransactionType.IN);
		transaction.setTransactionDate(account.getCreationDate());
		transaction.setAccount(accountsRepository.getAccountByTimeStampAndBalance(account.getCreationDate(), account.getBalance()));
		transactionService.addTransaction(transaction);
		
		
	}

	
	public Account findByID(long ID) {
		Optional<Account> account = accountsRepository.findById(ID);
		if(account.isPresent()) {
			return account.get();
		}
		else return null;
	}
	
	public List<Account> findAllAccounts() {
		return (List<Account>) accountsRepository.findAll();
	}
	
	public boolean exists(Account accounts) {
		return accountsRepository.existsById(accounts.getId());
	}

	@Transactional
	public void updateAccount(Transaction transactions) {
		if(transactions.getTransactionType() == TransactionType.OUT)
			accountsRepository.updateAccountReduceBalance(transactions.getAccount().getId(), transactions.getAccount().getCreationDate(), transactions.getAmmount());
		else 
			accountsRepository.updateAccountIncreaseBalance(transactions.getAccount().getId(), transactions.getAccount().getCreationDate(), transactions.getAmmount());
	}

}
