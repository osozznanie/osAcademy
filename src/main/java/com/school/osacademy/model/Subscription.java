package com.school.osacademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    @Column(name = "subscription_status")
    private String subscriptionStatus;
    @Column(name = "amount_of_lessons")
    private String amountOfLessons;
    @Column(name = "amount_of_lessons_completed")
    private String amountOfLessonsCompleted;
    @Column(name = "subscription_start_date")
    private LocalDate subscriptionStartDate;
    @Column(name = "subscription_end_date")
    private String amountOfSales;
}
