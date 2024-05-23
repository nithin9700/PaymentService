package com.nithin.paymentservice.Model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Currency extends BaseModel{
    private String currencyCode;
    private String currencyName;
    private String country;
}
