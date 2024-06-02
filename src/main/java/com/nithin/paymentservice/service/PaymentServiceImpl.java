package com.nithin.paymentservice.service;

import com.nithin.paymentservice.DTO.PaymentRequestDTO;
import com.nithin.paymentservice.Model.Payment;
import com.nithin.paymentservice.config.RazorpayConfig;
import com.nithin.paymentservice.repository.PaymentRepository;
import com.razorpay.PaymentLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RazorpayConfig razorpayConfig;

    public String createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        //todo:  insert the request DTO as a new payment inside the payment service DB -> payment table with status INPROGRESS
        Payment payment = PaymentRequestDTO.fromPayment(paymentRequestDTO);
        paymentRepository.save(payment);
        RazorpayClient razorpay = razorpayConfig.getRazorpayClient();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDTO.getAmount());
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
        paymentLinkRequest.put("callback_url","https://dory-exact-ladybug.ngrok-free.app/webhook");
        paymentLinkRequest.put("callback_method","get");
        PaymentLink razorpayPayment = razorpay.paymentLink.create(paymentLinkRequest);
        return razorpayPayment.toString();
    }



}
