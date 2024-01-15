package com.shehanrathnayake.service.custom;

import com.shehanrathnayake.entity.Customer;
import com.shehanrathnayake.service.SuperService;
import com.shehanrathnayake.to.CustomerTO;

import java.util.List;

public interface CustomerService extends SuperService {
    CustomerTO saveCustomer(CustomerTO customerTO);
    void updateCustomer(CustomerTO customerTO);
    void deleteCustomer(String customerId);
    CustomerTO getCustomerDetails(String customerId);
    List<CustomerTO> getCustomerList();
}
