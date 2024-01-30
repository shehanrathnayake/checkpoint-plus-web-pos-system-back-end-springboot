package com.shehanrathnayake.service.custom.impl;

import com.shehanrathnayake.converter.IdConverter;
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

    private final CustomerRepository customerRepository;
    private final CustomerTransformer customerTransformer;
    private final IdConverter idConverter;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerTransformer customerTransformer, IdConverter idConverter) {
        this.customerRepository = customerRepository;
        this.customerTransformer = customerTransformer;
        this.idConverter = idConverter;
    }

    @Override
    public CustomerTO saveCustomer(CustomerTO customerTO) {
        Customer savedCustomer = customerRepository.save(customerTransformer.fromCustomerTO(customerTO));
        return customerTransformer.toCustomerTO(savedCustomer);
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {
        customerRepository.findById(idConverter.convertCustomerIdToInt(customerTO.getCustomerId())).orElseThrow(() -> new AppException(404, "Customer not found"));
        customerRepository.save(customerTransformer.fromCustomerTO(customerTO));
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.findById(idConverter.convertCustomerIdToInt(customerId)).orElseThrow(() -> new AppException(404, "Customer not found"));
        customerRepository.deleteById(idConverter.convertCustomerIdToInt(customerId));
    }

    @Override
    public CustomerTO getCustomerDetails(String customerId) {
        Customer targetCustomer = customerRepository.findById(idConverter.convertCustomerIdToInt(customerId)).orElseThrow(() -> new AppException(404, "Customer not found"));
        return customerTransformer.toCustomerTO(targetCustomer);

    }

    @Override
    public List<CustomerTO> getCustomerList() {
        List<Customer> customerList = customerRepository.findAll();
        return customerTransformer.toCustomerTOList(customerList);
    }
}
