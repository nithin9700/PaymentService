package com.nithin.paymentservice.service;

import java.util.UUID;

public interface WebhookPayment {

    void updatePaymentStatus(UUID paymentId, String paymentStatus);

}
