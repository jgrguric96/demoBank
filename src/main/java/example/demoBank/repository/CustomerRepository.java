package example.demoBank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.demoBank.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
