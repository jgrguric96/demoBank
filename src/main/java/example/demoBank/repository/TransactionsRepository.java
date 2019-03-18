package example.demoBank.repository;

import org.springframework.data.repository.CrudRepository;

import example.demoBank.entity.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, Long>{

}
