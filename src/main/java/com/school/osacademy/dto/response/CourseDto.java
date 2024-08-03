package com.school.osacademy.dto.response;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String imageUrl;
    private String videoUrl;
    private String price;
    private String duration;
}
