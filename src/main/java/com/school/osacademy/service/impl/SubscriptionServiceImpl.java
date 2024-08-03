package com.school.osacademy.service.impl;

import com.school.osacademy.dto.response.SubscriptionDto;
import com.school.osacademy.mapper.SubscriptionMapper;
import com.school.osacademy.repository.SubscriptionRepository;
import com.school.osacademy.service.SubscriptionService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDto save(SubscriptionDto subscriptionDto) {
        return subscriptionMapper.toSubscriptionDto(
            subscriptionRepository.save(subscriptionMapper.toSubscription(subscriptionDto))
        );
    }

    @Override
    public SubscriptionDto updateById(SubscriptionDto subscriptionDto) {
        Optional<SubscriptionDto> optionalSubscriptionDto = getById(subscriptionDto.getId());

        if (optionalSubscriptionDto.isPresent()) {
            SubscriptionDto findSubscriptionDto = optionalSubscriptionDto.get();
            findSubscriptionDto.setId(subscriptionDto.getId());
            findSubscriptionDto.setUser(subscriptionDto.getUser());
            findSubscriptionDto.setCourseDto(subscriptionDto.getCourseDto());
            findSubscriptionDto.setSubscriptionStatus(subscriptionDto.getSubscriptionStatus());
            findSubscriptionDto.setAmountOfLessons(subscriptionDto.getAmountOfLessons());
            findSubscriptionDto.setAmountOfLessonsCompleted(subscriptionDto.getAmountOfLessonsCompleted());
            findSubscriptionDto.setSubscriptionStartDate(subscriptionDto.getSubscriptionStartDate());
            findSubscriptionDto.setSubscriptionEndDate(subscriptionDto.getSubscriptionEndDate());

            return subscriptionMapper.toSubscriptionDto(
                subscriptionRepository.save(subscriptionMapper.toSubscription(findSubscriptionDto))
            );
        } else {
            return null;
        }
    }

    @Override
    public Optional<SubscriptionDto> getById(Long id) {
        return subscriptionRepository.findById(id).map(subscriptionMapper::toSubscriptionDto);
    }

    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionRepository.findAll()
            .stream()
            .map(subscriptionMapper::toSubscriptionDto)
            .toList();
    }

    @Override
    public void deleteById(Long id) {
        try {
            subscriptionRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
