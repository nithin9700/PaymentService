package com.nithin.paymentservice.repository;


import com.nithin.paymentservice.Model.Currency;
import com.nithin.paymentservice.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

}