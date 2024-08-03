package com.school.osacademy.service;

public interface PaymentService {
    //TODO: Make sure witch methods should be implemented
    void makePayment(Long subscriptionId);
    void refundPayment(Long subscriptionId);
    void cancelPayment(Long subscriptionId);
    void updatePaymentStatus(Long subscriptionId);

}
