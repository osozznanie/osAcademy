package com.school.osacademy.model;

import com.school.osacademy.enums.PaymentStatus;
import java.time.LocalDate;
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
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private String userId;
    private String courseId;
    private String amount;
    private String transactionId;
    private PaymentStatus paymentStatus;
    private LocalDate paymentDate;

}
