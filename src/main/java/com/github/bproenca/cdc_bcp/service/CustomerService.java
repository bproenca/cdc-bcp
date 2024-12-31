package com.github.bproenca.cdc_bcp.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bproenca.cdc_bcp.entity.Customer;
import com.github.bproenca.cdc_bcp.repository.CustomerRepository;

import io.debezium.data.Envelope.Operation;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void replicateData(Map<String, Object> customerData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final Customer customer = mapper.convertValue(customerData, Customer.class);

        if (Operation.DELETE == operation) {
            customerRepository.deleteById(customer.getId());
        } else {
            customer.setFullname(customer.getFullname().toUpperCase());
            customerRepository.save(customer);
        }
    }
}