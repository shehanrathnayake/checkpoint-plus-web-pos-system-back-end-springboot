package com.shehanrathnayake.service.util;

import com.shehanrathnayake.entity.Customer;
import com.shehanrathnayake.to.CustomerTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerTransformer {
    private final ModelMapper mapper;

    public CustomerTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Customer fromCustomerTO(CustomerTO customerTO) {
        return mapper.map(customerTO, Customer.class);
    }

    public CustomerTO toCustomerTO(Customer customer) {
        return mapper.map(customer, CustomerTO.class);
    }

    public List<CustomerTO> toCustomerTOList(List<Customer> customerList) {
        return customerList.stream().map(this::toCustomerTO).collect(Collectors.toList());
    }
}
