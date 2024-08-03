package com.school.osacademy.mapper;

import com.school.osacademy.dto.response.SubscriptionDto;
import com.school.osacademy.model.Subscription;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubscriptionMapper {

    private UserMapper userMapper;
    private CourseMapper courseMapper;

    public SubscriptionDto toSubscriptionDto(Subscription subscription) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setUser(userMapper.toUserDtoFromModel(subscription.getUser()));
        subscriptionDto.setCourseDto(courseMapper.toCourseDto(subscription.getCourse()));
        subscriptionDto.setSubscriptionStatus(subscription.getSubscriptionStatus());
        subscriptionDto.setAmountOfLessons(subscription.getAmountOfLessons());
        subscriptionDto.setAmountOfLessonsCompleted(subscription.getAmountOfLessonsCompleted());
        subscriptionDto.setSubscriptionStartDate(subscription.getSubscriptionStartDate());
        subscriptionDto.setSubscriptionEndDate(subscription.getSubscriptionEndDate());
        return subscriptionDto;
    }

    public Subscription toSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();
        subscription.setId(subscriptionDto.getId());
        subscription.setUser(userMapper.toUserFromDto(subscriptionDto.getUser()));
        subscription.setCourse(courseMapper.toCourse(subscriptionDto.getCourseDto()));
        subscription.setSubscriptionStatus(subscriptionDto.getSubscriptionStatus());
        subscription.setAmountOfLessons(subscriptionDto.getAmountOfLessons());
        subscription.setAmountOfLessonsCompleted(subscriptionDto.getAmountOfLessonsCompleted());
        subscription.setSubscriptionStartDate(subscriptionDto.getSubscriptionStartDate());
        subscription.setSubscriptionEndDate(subscriptionDto.getSubscriptionEndDate());
        return subscription;
    }

}
