package com.school.osacademy.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "subscriptions")
public class Subscription {

    @Id
    private String id;
    private String userId;
    private String courseId;
    private String subscriptionStatus;
    private String amountOfLessons;
    private String amountOfLessonsCompleted;
    private LocalDate subscriptionStartDate;
    private String amountOfSales;
}
