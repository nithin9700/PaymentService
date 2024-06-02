package com.nithin.paymentservice.controller;


import com.nithin.paymentservice.DTO.PaymentRequestDTO;
import com.nithin.paymentservice.service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("createPayment")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        return new ResponseEntity<>(paymentService.createPayment(paymentRequestDTO), HttpStatus.OK);
    }
    @GetMapping("hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        System.out.println(name + "has tried");
        return ResponseEntity.ok("hello");
    }

}
