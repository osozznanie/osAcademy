package com.school.osacademy.service;

import com.school.osacademy.dto.response.CourseDto;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    CourseDto save(CourseDto courseDto);
    CourseDto updateById(CourseDto courseDto);
    Optional<CourseDto> getById(Long id);
    Page<CourseDto> getAll(Pageable pageable);
    void deleteById(Long id);
}
