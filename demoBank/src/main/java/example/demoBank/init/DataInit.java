package example.demoBank.init;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import example.demoBank.dto.request.NewAccountRequest;
import example.demoBank.entity.Account;
import example.demoBank.entity.Customer;
import example.demoBank.entity.Transaction;
import example.demoBank.entity.TransactionType;
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
	private NewAccountRequest newAccount;

	
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
//			Account account = new Account();
			Transaction transaction = new Transaction();
			Random random = new Random();
			Long value;
			
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
				customer.setId(Integer.toUnsignedLong(i)+1);
				customer.setName(firstNames.get(i));
				customer.setSurname(lastNames.get(i));
				customerService.addCustomer(customer);
			}
			
			for(int i = 0; i < 6; i++)
			{
				value = Long.valueOf(random.nextInt(4)+1);
				newAccount.setCustomerID(value);
				newAccount.setInitialCredit(balance.get(i));
				accountsService.addAccount(newAccount);
				transaction.setId(null);
				if(i%2 == 0) {
					Date date = new Date();
					transaction.setAmmount(BigDecimal.valueOf(10000));
					transaction.setTransactionType(TransactionType.OUT);
					transaction.setTransactionDate(date);
					transaction.setAccount(accountsService.findByID(Long.valueOf(i+1)));
					transactionsService.addTransaction(transaction);
				}
				
			}
			
		}

	}

}
