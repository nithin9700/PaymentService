package com.nithin.paymentservice.DTO;

import com.nithin.paymentservice.Model.Payment;
import com.nithin.paymentservice.Model.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class PaymentRequestDTO {
    private long amount;
    private UUID orderId;
    private String description;
    private UUID userId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    public static Payment fromPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setOrderId(paymentRequestDTO.getOrderId());
        return payment;
    }
}

