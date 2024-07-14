package com.school.osacademy.model;

import com.school.osacademy.enums.ERole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String avatar;
    private ERole role;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "is_subscribed")
    private boolean isSubscribed;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

}
