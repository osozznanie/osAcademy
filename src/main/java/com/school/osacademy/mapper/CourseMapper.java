package com.school.osacademy.mapper;

import com.school.osacademy.dto.response.CourseDto;
import com.school.osacademy.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDto toCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setCategory(course.getCategory());
        courseDto.setImageUrl(course.getImageUrl());
        courseDto.setVideoUrl(course.getVideoUrl());
        courseDto.setDuration(course.getDuration());
        courseDto.setDescription(course.getDescription());
        courseDto.setPrice(course.getPrice());
        return courseDto;
    }

    public Course toCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setCategory(courseDto.getCategory());
        course.setImageUrl(courseDto.getImageUrl());
        course.setVideoUrl(courseDto.getVideoUrl());
        course.setDuration(courseDto.getDuration());
        course.setDescription(courseDto.getDescription());
        course.setPrice(courseDto.getPrice());
        return course;
    }
}
