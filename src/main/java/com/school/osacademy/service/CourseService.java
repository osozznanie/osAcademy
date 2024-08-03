package com.school.osacademy.service;

import com.school.osacademy.dto.response.CourseDto;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDto save(CourseDto courseDto);
    CourseDto updateById(CourseDto courseDto);
    Optional<CourseDto> getById(Long id);
    List<CourseDto> getAll();
    void deleteById(Long id);
}
