package example.demoBank.init;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import example.demoBank.entity.Accounts;
import example.demoBank.entity.Customer;
import example.demoBank.entity.Transactions;
import example.demoBank.repository.AccountsRepository;
import example.demoBank.repository.CustomerRepository;
import example.demoBank.service.implemented.AccountsService;
import example.demoBank.service.implemented.CustomerService;
import example.demoBank.service.implemented.TransactionsService;

@Component
public class DataInit implements ApplicationRunner{
	
	
	//spring.datasource.url=jdbc:h2:file:~/eclipse-workspace/demoBank/demoBankDB
	
	
	private CustomerService customerService;
	private AccountsService accountsService;
	private TransactionsService transactionsService;

	
	@Autowired
	public DataInit(CustomerService customerService, AccountsService accountsService, TransactionsService transactionsService)
	{
		this.customerService = customerService;
		this.accountsService = accountsService;
		this.transactionsService = transactionsService;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		if(customerService.count() == 0) {
			Customer customer = new Customer();
			Accounts account = new Accounts();
			Transactions transaction = new Transactions();
			Random random = new Random();
			int offset = 0;
			
			List<String> firstNames = Arrays.asList(
				"Marko","Kieran","Filip","Laura"
			);
			List<String> lastNames = Arrays.asList(
				"Ivis","Keyes","Bran","Rim"
			);
			
			List<BigDecimal> balance = Arrays.asList(
				BigDecimal.valueOf(25000),BigDecimal.valueOf(158000), BigDecimal.valueOf(13370), 
				BigDecimal.valueOf(11000), BigDecimal.valueOf(15000), BigDecimal.valueOf(500000)
			);
			
			
			for(int i = 0; i < firstNames.size();i++)
			{
				customer.setCustomerID(Integer.toUnsignedLong(i)+1);
				customer.setName(firstNames.get(i));
				customer.setSurname(lastNames.get(i));
				customerService.addCustomer(customer);
			}
			
			for(int i = 0; i < 6; i++)
			{
				account.setAccountID(Integer.toUnsignedLong(i)+1);
				account.setBalance(balance.get(i));
				if(i%2==0) account.setInitialCredit(balance.get(i));
				else account.setInitialCredit(balance.get(i).add(BigDecimal.valueOf(10000)));
				account.setCustomer(customerService.findByID(random.nextInt(4)+1));
				accountsService.addAccount(account);
				
				transaction.setTransactionID(Integer.toUnsignedLong(i)+1+offset);
				transaction.setAccounts(accountsService.findByID(Integer.toUnsignedLong(i)+1));
				if(i%2==0) {
					transaction.setAmmount(balance.get(i));
					transactionsService.addTransaction(transaction);
				}
				else {
					++offset;
					transaction.setAmmount(balance.get(i).add(BigDecimal.valueOf(10000)));
					transactionsService.addTransaction(transaction);
					transaction.setAmmount(BigDecimal.valueOf(-10000));
					transaction.setTransactionID(Integer.toUnsignedLong(i)+1+offset);
					transactionsService.addTransaction(transaction);
					
				}
			}
			
		}

	}

}
