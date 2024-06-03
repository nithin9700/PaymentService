package com.nithin.paymentservice.service;

import com.nithin.paymentservice.Model.enums.PaymentStatus;


public interface WebhookPayment {

    PaymentStatus updatePaymentStatus(String razorpay_payment_id,
                                      String razorpay_payment_link_reference_id,
                                      String razorpay_payment_link_status);


}
