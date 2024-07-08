package com.school.osacademy.model;

import com.school.osacademy.enums.ERole;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String avatar;
    private ERole role;
    private LocalDate registrationDate;
    private boolean isVerified;
    private boolean isSubscribed;
    private List<Subscription> subscriptions;

}
