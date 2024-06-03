package com.nithin.paymentservice.controller;


import com.nithin.paymentservice.Model.enums.PaymentStatus;
import com.nithin.paymentservice.service.WebhookPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PaymentWebhook {
    @Autowired
    private WebhookPayment webhookPayment;

    @GetMapping("/webhook")
    public ResponseEntity<?> handleWebhookEvent(@RequestParam(value = "razorpay_payment_id", required = false) String razorpayPaymentId,
                                                @RequestParam(value = "razorpay_payment_link_reference_id", required = false) String razorpayPaymentLinkReferenceId,
                                                @RequestParam(value = "razorpay_payment_link_status", required = false) String razorpayPaymentLinkStatus){
        PaymentStatus paymentStatus = webhookPayment.updatePaymentStatus(razorpayPaymentId,
                razorpayPaymentLinkReferenceId,
                razorpayPaymentLinkStatus);

        return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
    }
}



/*
https://c722-183-83-129-211.ngrok-free.app/webhook?
razorpay_payment_id=pay_OIM0Z8xr39fd8m
razorpay_payment_link_id=plink_OIM0LI0FmbNSV5
razorpay_payment_link_reference_id=
razorpay_payment_link_status=paid
razorpay_signature=55d8d6775c8283c184caa7e136cfa5e6378c0419b8e07272b17ed2b606ce39f6
 */