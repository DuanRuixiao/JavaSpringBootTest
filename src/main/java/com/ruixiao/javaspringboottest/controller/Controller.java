package com.ruixiao.javaspringboottest.controller;

import com.ruixiao.javaspringboottest.model.Customer;
import com.ruixiao.javaspringboottest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Integer id, @RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = customerRepository.findCustomerById(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        customerRepository.save(customer);

        return "Updated customer given ID: " + id.toString();
    }
}
