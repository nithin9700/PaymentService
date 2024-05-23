package com.nithin.paymentservice.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import com.nithin.paymentservice.Model.enums.PaymentStatus;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private double amount;
    @OneToOne
    private Currency currency;
    private String transactionId;
    private UUID orderId;
    private UUID userId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

}
