package com.nithin.paymentservice.DTO;

import com.nithin.paymentservice.Model.Payment;
import com.nithin.paymentservice.Model.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentRequestDTO {
    private long amount;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    public static Payment fromPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        return payment;
    }
}

