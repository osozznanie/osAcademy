package com.school.osacademy.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SubscriptionDto {
    private Long id;
    private UserDto user;
    private CourseDto courseDto;
    private String subscriptionStatus;
    private String amountOfLessons;
    private String amountOfLessonsCompleted;
    private LocalDate subscriptionStartDate;
    private String subscriptionEndDate;
}
