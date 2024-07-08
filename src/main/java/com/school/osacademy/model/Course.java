package com.school.osacademy.model;

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
@Document(collection = "courses")
public class Course {

    @Id
    private String id;
    private String title;
    private String description;
    //TODO probably it is age (category by age)
    private String category;
    private String imageUrl;
    private String videoUrl;
    private String price;
    private String duration;
}
