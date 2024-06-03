package com.nithin.paymentservice.service;

import com.nithin.paymentservice.Model.Payment;
import com.nithin.paymentservice.Model.enums.PaymentStatus;
import com.nithin.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WebhookPaymentImpl implements WebhookPayment {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public PaymentStatus updatePaymentStatus(String razorpay_payment_id,
                                    String razorpay_payment_link_reference_id,
                                    String razorpay_payment_link_status) {
        UUID orderId = UUID.fromString(razorpay_payment_link_reference_id);
        Optional<Payment> payment = paymentRepository.findByOrderId(orderId);
        Payment payment1 =  payment.get();
        payment1.setTransactionId(razorpay_payment_id);
        if(razorpay_payment_link_status.equals("Paid")) {
            payment1.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        }
        paymentRepository.save(payment1);
        return razorpay_payment_link_status.equals("Paid") ? PaymentStatus.SUCCESSFUL : PaymentStatus.FAILED;
    }
}
