package com.nithin.paymentservice.controller;


import com.nithin.paymentservice.service.PaymentService;
import com.nithin.paymentservice.service.WebhookPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class PaymentWebhook {
    @Autowired
    private WebhookPayment webhookPayment;

    @PostMapping("/webhook")
    public ResponseEntity<?> handleWebhookEvent(@RequestBody Map<String, Object> payload) {
        // Extract relevant data from the webhook payload
        UUID paymentId = (UUID) payload.get("payment_id");
        String status = (String) payload.get("status");
        // Extract other relevant data as needed

        if ("successful".equals(status)) {
            // Update database if payment is successful
            try {
                webhookPayment.updatePaymentStatus(paymentId, "SUCCESS");

                return ResponseEntity.ok("Payment updated successfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating payment");
            }
        } else {
            // Handle other payment statuses if needed
            return ResponseEntity.ok("Payment status: " + status);
        }
    }
}
