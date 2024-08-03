package com.school.osacademy.repository;

import com.school.osacademy.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
}
