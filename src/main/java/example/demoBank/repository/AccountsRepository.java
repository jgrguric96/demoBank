package example.demoBank.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import example.demoBank.entity.Account;

public interface AccountsRepository extends CrudRepository<Account, Long>{
	
	@Query("SELECT a FROM Account a WHERE a.creationDate = :timeStamp AND a.balance = :balance")
	Account getAccountByTimeStampAndBalance(Date timeStamp, BigDecimal balance);
	
	@Modifying
	@Query("UPDATE Account a SET a.balance = a.balance - :newBalance WHERE a.id = :id AND a.creationDate = :timeStamp")
	void updateAccountReduceBalance(Long id, Date timeStamp, BigDecimal newBalance);
	
	@Modifying
	@Query("UPDATE Account a SET a.balance = a.balance + :newBalance WHERE a.id = :id AND a.creationDate = :timeStamp")
	void updateAccountIncreaseBalance(Long id, Date timeStamp, BigDecimal newBalance);
	/* @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    public List<Person> find(@Param("lastName") String lastName);*/
}
