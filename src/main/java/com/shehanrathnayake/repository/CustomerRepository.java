package com.shehanrathnayake.repository;

import com.shehanrathnayake.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
