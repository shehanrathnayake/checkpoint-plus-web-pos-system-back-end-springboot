package com.shehanrathnayake.api;

import com.shehanrathnayake.service.custom.CustomerService;
import com.shehanrathnayake.to.CustomerTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerHttpController {

    private final CustomerService service;

    public CustomerHttpController(CustomerService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CustomerTO createNewCustomer(@RequestBody @Validated CustomerTO customerTO) {
        return service.saveCustomer(customerTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{customer-id}", consumes = "application/json")
    public void updateCustomer(@PathVariable("customer-id") String customerId,
                               @RequestBody @Validated CustomerTO customerTO) {
        customerTO.setCustomerId(customerId);
        service.updateCustomer(customerTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{customer-id}")
    public void deleteCustomer(@PathVariable("customer-id") String customerId) {
        service.deleteCustomer(customerId);
    }

    @GetMapping(value = "/{customer-id}", produces = "application/json")
    public CustomerTO getCustomer(@PathVariable("customer-id") String customerId) {
        return service.getCustomerDetails(customerId);
    }

    @GetMapping(produces = "application/json")
    public List<CustomerTO> getAllCustomers() {
        return service.getCustomerList();
    }
}
