package com.nithin.paymentservice.config;

import com.nithin.paymentservice.DTO.PaymentRequestDTO;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
public class RazorpayConfig {
    @Value("${RAZORPAY_KEY}")
    private String key;
    @Value("${RAZORPAY_SECRET}")
    private String secret;

    public  RazorpayClient getRazorpayClient() throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(key, secret);
        return razorpay;
    }

}
