package com.school.osacademy.repository;

import com.school.osacademy.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
