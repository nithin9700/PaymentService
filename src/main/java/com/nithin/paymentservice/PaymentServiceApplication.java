package com.nithin.paymentservice;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class PaymentServiceApplication {

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    public void addApplication(){
        eurekaClient.getApplications(applicationName);
    }
}
