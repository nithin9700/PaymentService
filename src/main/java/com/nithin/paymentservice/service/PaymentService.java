package com.nithin.paymentservice.service;

import com.nithin.paymentservice.DTO.PaymentRequestDTO;
import com.nithin.paymentservice.Model.Payment;
import com.razorpay.RazorpayException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface PaymentService {
    String createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException;
}
