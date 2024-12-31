package com.github.bproenca.cdc_bcp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.bproenca.cdc_bcp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}