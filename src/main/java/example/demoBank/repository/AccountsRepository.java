package example.demoBank.repository;

import org.springframework.data.repository.CrudRepository;

import example.demoBank.entity.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long>{
	

}
