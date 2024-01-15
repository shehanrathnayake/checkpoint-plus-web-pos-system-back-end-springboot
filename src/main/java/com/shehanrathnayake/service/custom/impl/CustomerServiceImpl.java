package com.shehanrathnayake.service.custom.impl;

import com.shehanrathnayake.entity.Customer;
import com.shehanrathnayake.exception.AppException;
import com.shehanrathnayake.repository.CustomerRepository;
import com.shehanrathnayake.service.custom.CustomerService;
import com.shehanrathnayake.service.util.CustomerTransformer;
import com.shehanrathnayake.to.CustomerTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository repository;
    public final CustomerTransformer transformer;

    public CustomerServiceImpl(CustomerRepository repository, CustomerTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    @Override
    public CustomerTO saveCustomer(CustomerTO customerTO) {

        Optional<Customer> optLastCustomer = repository.findLastCustomer();
        String newCustomerId;
        if (optLastCustomer.isEmpty()) newCustomerId = "C000001";
        else newCustomerId = String.format("C%06d", Integer.parseInt(optLastCustomer.get().getCustomerId().substring(1)) + 1);
        customerTO.setCustomerId(newCustomerId);

        Customer customer = transformer.fromCustomerTO(customerTO);
        Customer savedCustomer = repository.save(customer);
        return transformer.toCustomerTO(savedCustomer);
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {
        repository.findById(customerTO.getCustomerId()).orElseThrow(() -> new AppException(404, "Customer not found"));
        Customer updatedCustomer = transformer.fromCustomerTO(customerTO);
        repository.save(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new AppException(404, "Customer not found"));
        repository.delete(customer);
    }

    @Override
    public CustomerTO getCustomerDetails(String customerId) {
        Optional<Customer> optCustomer = repository.findById(customerId);
        if (optCustomer.isEmpty()) throw new AppException(404, "Customer not found");
        return transformer.toCustomerTO(optCustomer.get());
    }

    @Override
    public List<CustomerTO> getCustomerList() {
        List<Customer> customerList = repository.findAll();
        return transformer.toCustomerTOList(customerList);
    }
}
