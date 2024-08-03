package com.school.osacademy.service.impl;

import com.school.osacademy.dto.response.CourseDto;
import com.school.osacademy.mapper.CourseMapper;
import com.school.osacademy.model.Course;
import com.school.osacademy.repository.CourseRepository;
import com.school.osacademy.service.CourseService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto save(CourseDto courseDto) {
        return courseMapper.toCourseDto(
            courseRepository.save(courseMapper.toCourse(courseDto))
        );
    }

    @Override
    public CourseDto updateById(CourseDto courseDto) {
        Optional<CourseDto> optionalCourseDto = getById(courseDto.getId());

        if (optionalCourseDto.isPresent()) {
            CourseDto findCourseDto = optionalCourseDto.get();
            findCourseDto.setId(courseDto.getId());
            findCourseDto.setTitle(courseDto.getTitle());
            findCourseDto.setCategory(courseDto.getCategory());
            findCourseDto.setImageUrl(courseDto.getImageUrl());
            findCourseDto.setVideoUrl(courseDto.getVideoUrl());
            findCourseDto.setDuration(courseDto.getDuration());
            findCourseDto.setDescription(courseDto.getDescription());
            findCourseDto.setPrice(courseDto.getPrice());

            Course updatedCourse = courseRepository.save(courseMapper.toCourse(findCourseDto));
            return courseMapper.toCourseDto(updatedCourse);
        } else {
            return null;
        }
    }


    @Override
    public Optional<CourseDto> getById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toCourseDto);
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll()
            .stream()
            .map(courseMapper::toCourseDto)
            .toList();
    }

    @Override
    public void deleteById(Long id) {
        try {
            courseRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
