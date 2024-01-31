package com.shehanrathnayake.service.util;

import com.shehanrathnayake.entity.Customer;
import com.shehanrathnayake.to.CustomerTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomerTransformerTest {
    @Autowired
    private CustomerTransformer transformer;

    @Test
    void fromCustomerTO() {
        CustomerTO customerTO = new CustomerTO("C000001", "Shehan", "0771313951", "Colombo");
        Customer customer = transformer.fromCustomerTO(customerTO);
        assertNotNull(customer);
//        assertEquals(customer.getCustomerId(), customerTO.getCustomerId());
        assertEquals(customer.getName(), customerTO.getName());
        assertEquals(customer.getPhone(), customerTO.getPhone());
        assertEquals(customer.getAddress(), customerTO.getAddress());
    }

    @Test
    void toCustomerTO() {
        Customer customer = new Customer(1, "Shehan", "0771313951", "Colombo");
        CustomerTO customerTO = transformer.toCustomerTO(customer);
        assertNotNull(customerTO);
//        assertEquals(customer.getCustomerId(), customerTO.getCustomerId());
        assertEquals(customer.getName(), customerTO.getName());
        assertEquals(customer.getPhone(), customerTO.getPhone());
        assertEquals(customer.getAddress(), customerTO.getAddress());
    }

    @Test
    void toCustomerTOList() {
        List<Customer> customerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Customer customer = new Customer( i, "Shehan", "0771313951", "Colombo");
            customerList.add(customer);
        }
        List<CustomerTO> customerTOList = transformer.toCustomerTOList(customerList);
        assertEquals(customerTOList.size(), customerList.size());
    }
}