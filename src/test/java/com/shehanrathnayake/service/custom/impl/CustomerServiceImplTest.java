package com.shehanrathnayake.service.custom.impl;

import com.shehanrathnayake.entity.Customer;
import com.shehanrathnayake.exception.AppException;
import com.shehanrathnayake.repository.CustomerRepository;
import com.shehanrathnayake.service.custom.CustomerService;
import com.shehanrathnayake.to.CustomerTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomerServiceImplTest {
    @Autowired
    private CustomerService service;

    @Test
    void saveCustomer() {
        CustomerTO customerTO = new CustomerTO("Shehan Rathnayake", "0711313951", "Colombo");
        CustomerTO savedCustomerTO = service.saveCustomer(customerTO);
        assertNotNull(savedCustomerTO);
        assertEquals(savedCustomerTO.getCustomerId(), "C000001");
        assertEquals(savedCustomerTO.getName(), "Shehan Rathnayake");
        assertEquals(savedCustomerTO.getPhone(), "0711313951");
        assertEquals(savedCustomerTO.getAddress(), "Colombo");
    }

    @Test
    void updateCustomer() {
        CustomerTO customerTO = new CustomerTO("Shehan Rathnayake", "0711313951", "Colombo");
        CustomerTO savedCustomerTO = service.saveCustomer(customerTO);
        assertNotNull(savedCustomerTO);

        savedCustomerTO.setName("Jagath");
        savedCustomerTO.setPhone("0771234567");
        savedCustomerTO.setAddress("Kandy");

        service.updateCustomer(savedCustomerTO);
        CustomerTO foundCustomerTO = service.getCustomerDetails(savedCustomerTO.getCustomerId());

        assertNotNull(foundCustomerTO);
        assertEquals(foundCustomerTO.getCustomerId(), savedCustomerTO.getCustomerId());
        assertEquals(foundCustomerTO.getName(), "Jagath");
        assertEquals(foundCustomerTO.getPhone(), "0771234567");
        assertEquals(foundCustomerTO.getAddress(), "Kandy");
    }

    @Test
    void deleteCustomer() {
        CustomerTO customerTO = new CustomerTO("Shehan Rathnayake", "0711313951", "Colombo");
        CustomerTO savedCustomerTO = service.saveCustomer(customerTO);
        assertNotNull(savedCustomerTO);

        service.deleteCustomer(savedCustomerTO.getCustomerId());
        assertThrows(AppException.class, () -> service.getCustomerDetails(savedCustomerTO.getCustomerId()));
    }

    @Test
    void getCustomerDetails() {
        CustomerTO customerTO = new CustomerTO("Shehan Rathnayake", "0711313951", "Colombo");
        CustomerTO savedCustomerTO = service.saveCustomer(customerTO);
        assertNotNull(savedCustomerTO);

        customerTO = service.getCustomerDetails(savedCustomerTO.getCustomerId());
        assertNotNull(customerTO);
        assertEquals(customerTO.getCustomerId(), savedCustomerTO.getCustomerId());
        assertEquals(customerTO.getName(), savedCustomerTO.getName());
        assertEquals(customerTO.getPhone(), savedCustomerTO.getPhone());
        assertEquals(customerTO.getAddress(), savedCustomerTO.getAddress());

        assertThrows(AppException.class, () -> service.getCustomerDetails("U1255555"));
    }

    @Test
    void getCustomerList() {
        for (int i = 0; i < 9; i++) {
            CustomerTO customerTO = new CustomerTO("Shehan", "0711313951", "Colombo");
            service.saveCustomer(customerTO);
        }
        List<CustomerTO> customerList = service.getCustomerList();
        assertEquals(customerList.size(), 9);
    }
}