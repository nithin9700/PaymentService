package com.nithin.paymentservice.service;

import com.nithin.paymentservice.DTO.PaymentRequestDTO;
import com.nithin.paymentservice.Model.Payment;
import com.nithin.paymentservice.config.RazorpayConfig;
import com.nithin.paymentservice.repository.PaymentRepository;
import com.razorpay.PaymentLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RazorpayConfig razorpayConfig;

    public String createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        //todo:  insert the request DTO as a new payment inside the payment service DB -> payment table with status INPROGRESS
        Payment payment = PaymentRequestDTO.fromPayment(paymentRequestDTO);

        RazorpayClient razorpay = razorpayConfig.getRazorpayClient();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDTO.getAmount());
        paymentLinkRequest.put("reference_id", paymentRequestDTO.getOrderId().toString());
        payment.setOrderId(paymentRequestDTO.getOrderId());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() + 600000);
        paymentLinkRequest.put("description", paymentRequestDTO.getDescription());
        JSONObject customer = new JSONObject();
        customer.put("name", paymentRequestDTO.getCustomerName());
        customer.put("contact",paymentRequestDTO.getCustomerPhone());
        customer.put("email",paymentRequestDTO.getCustomerEmail());
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        paymentLinkRequest.put("callback_url","https://c722-183-83-129-211.ngrok-free.app/webhook");
        paymentLinkRequest.put("callback_method","get");
        paymentRepository.save(payment);
        PaymentLink razorpayPayment = razorpay.paymentLink.create(paymentLinkRequest);
        return razorpayPayment.toString();
    }

}
