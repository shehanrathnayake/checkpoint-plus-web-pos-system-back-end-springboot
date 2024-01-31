package com.shehanrathnayake.repository;

import com.shehanrathnayake.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomerRepositoryImplTest {
    @Autowired
    private CustomerRepository repository;

    @PersistenceContext
    private EntityManager em;

    /*
    @Test
    void save() {
        Customer customer = new Customer(1, "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);
        Customer foundCustomer = em.find(Customer.class, savedCustomer.getCustomerId());

        assertEquals(savedCustomer.getCustomerId(), "C000001");
        assertNotNull(foundCustomer);
        assertEquals(savedCustomer.getCustomerId(), foundCustomer.getCustomerId());
        assertEquals(foundCustomer.getName(), "Shehan");
        assertEquals(foundCustomer.getPhone(), "0711313951");
        assertEquals(foundCustomer.getAddress(), "Colombo");
    }

    @Test
    void update() {
        Customer customer = new Customer("C000001", "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);

        savedCustomer.setName("Rathnayake");
        savedCustomer.setPhone("0771234567");
        savedCustomer.setAddress("Galle");
        Customer updatedCustomer = repository.save(savedCustomer);

        Customer foundCustomer = em.find(Customer.class, updatedCustomer.getCustomerId());

        assertNotNull(foundCustomer);
        assertEquals(foundCustomer.getCustomerId(), "C000001");
        assertEquals(foundCustomer.getName(), "Rathnayake");
        assertEquals(foundCustomer.getPhone(), "0771234567");
        assertEquals(foundCustomer.getAddress(), "Galle");
    }

    @Test
    void deleteById() {
        Customer customer = new Customer("C000001", "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer.getCustomerId(), "C000001");
        repository.delete(savedCustomer);
        Customer foundCustomer = em.find(Customer.class, "C000001");
        assertNull(foundCustomer);

    }

    @Test
    void existsById() {
        boolean isExists = repository.existsById("C000001");
        assertFalse(isExists);
        Customer customer = new Customer("C000001", "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer);

        isExists = repository.existsById("C000001");
        assertTrue(isExists);
        isExists = repository.existsById("C000025");
        assertFalse(isExists);
    }

    @Test
    void findById() {
        Optional<Customer> optCustomer = repository.findById("C000001");
        assertFalse(optCustomer.isPresent());
        Customer customer = new Customer("C000001", "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer);

        optCustomer = repository.findById("C000001");
        assertTrue(optCustomer.isPresent());
    }

    @Test
    void findAll() {
        for (int i = 0; i < 9; i++) {
            Customer customer = new Customer("C00000" + i + 1, "Shehan", "0711313951", "Colombo");
            repository.save(customer);
        }
        List<Customer> customerList = repository.findAll();
        assertEquals(customerList.size(), 9);
    }

    @Test
    void count() {
        for (int i = 0; i < 9; i++) {
            Customer customer = new Customer("C00000" + i + 1, "Shehan", "0711313951", "Colombo");
            repository.save(customer);
        }
        long count = repository.count();
        assertEquals(count, 9);
    }

    @Test
    void findLastCustomer() {
        Optional<Customer> lastCustomer = repository.findLastCustomer();
        assertTrue(lastCustomer.isEmpty());

        Customer customer = new Customer("C000001", "Shehan", "0711313951", "Colombo");
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer);

        lastCustomer = repository.findLastCustomer();
        assertTrue(lastCustomer.isPresent());
        assertEquals(lastCustomer.get().getCustomerId(), savedCustomer.getCustomerId());

        for (int i = 2; i <= 5; i++) {
            customer = new Customer("C00000" + i, "Shehan", "0711313951", "Colombo");
            repository.save(customer);
        }

        lastCustomer = repository.findLastCustomer();
        assertTrue(lastCustomer.isPresent());
        assertEquals(lastCustomer.get().getCustomerId(), "C000005");
    }
    */
}