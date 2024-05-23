package com.nithin.paymentservice.utils;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class schedule {
    @Scheduled(cron = "0 0 17 * * * TUE-FRI")
    public void cronSchedule() {

    }
}
