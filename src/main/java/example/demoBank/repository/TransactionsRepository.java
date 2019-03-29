package example.demoBank.repository;

import org.springframework.data.repository.CrudRepository;

import example.demoBank.entity.Transaction;

public interface TransactionsRepository extends CrudRepository<Transaction, Long>{

}
