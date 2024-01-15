package com.shehanrathnayake.repository;

import com.shehanrathnayake.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 1", nativeQuery = true)
    Optional<Customer> findLastCustomer();
}
