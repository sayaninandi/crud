package com.example.crud.service;

import com.example.crud.model.Customer;
import com.example.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("Amar", "", "", "amar@gmail.com"));
        customers.add(new Customer("Akbar", "", "", "akbar@gmail.com"));
        customers.add(new Customer("Anthony", "", "", "anthony@gmail.com"));
    }

    public void saveSomeCustomers() {
        customerRepository.saveAll(customers);
    }

    public Customer getCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));

        return customer;
    }
}
