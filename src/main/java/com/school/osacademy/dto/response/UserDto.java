package com.school.osacademy.dto.response;

import com.school.osacademy.enums.ERole;
import com.school.osacademy.model.Subscription;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String avatar;
    private ERole role;
    private LocalDate registrationDate;
    private boolean isVerified;
    private boolean isSubscribed;
    private List<Subscription> subscriptions;
}
