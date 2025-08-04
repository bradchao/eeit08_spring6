package tw.brad.spring6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.brad.spring6.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, String>{

	@Query("""
				SELECT c
				FROM Customer c
				WHERE c.customerid = :customerid
			""")	
	Optional<Customer> findByCustomerIdWithOrders(@Param("customerid") String customerId);
}
