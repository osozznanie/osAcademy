package com.school.osacademy.service;

import com.school.osacademy.dto.response.SubscriptionDto;
import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    SubscriptionDto save(SubscriptionDto subscriptionDto);

    SubscriptionDto updateById(SubscriptionDto subscriptionDto);

    Optional<SubscriptionDto> getById(Long id);

    List<SubscriptionDto> getAll();

    void deleteById(Long id);
}
