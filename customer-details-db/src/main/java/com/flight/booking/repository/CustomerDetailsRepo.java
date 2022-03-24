package com.flight.booking.repository;

import com.flight.booking.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface CustomerDetailsRepo extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByCustomerId(String customerId);
    @Transactional
    long deleteByCustomerId(String customerId);
}
