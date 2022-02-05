package com.smoothiemx.springdatajpa.hibernate.inheritance.repos;

import com.smoothiemx.springdatajpa.hibernate.inheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}