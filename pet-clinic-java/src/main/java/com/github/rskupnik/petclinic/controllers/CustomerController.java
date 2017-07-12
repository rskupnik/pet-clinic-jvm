package com.github.rskupnik.petclinic.controllers;

import com.github.rskupnik.petclinic.model.Customer;
import com.github.rskupnik.petclinic.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }

    @GetMapping(produces = "application/json")
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping(value = "/formatted", produces = "application/json")
    public List<String> getAllCustomersFormatted() {
        return ((List<Customer>) customerRepository.findAll())
                .stream()
                .map(
                    customer -> customer.getFirstName()+" "+customer.getLastName()
                )
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
