package com.school.osacademy.dto.response;

import com.school.osacademy.enums.PaymentStatus;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private UserDto userDto;
    private CourseDto courseDto;
    private String amount;
    private String transactionId;
    private PaymentStatus paymentStatus;
    private LocalDate paymentDate;
}
