package com.nithin.paymentservice.service;

import com.nithin.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebhookPaymentImpl implements WebhookPayment {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void updatePaymentStatus(UUID paymentId, String paymentStatus) {
       // paymentRepository.find(paymentId);
    }
}
