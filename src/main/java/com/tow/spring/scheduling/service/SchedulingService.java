package com.tow.spring.scheduling.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("schedulingService")
public class SchedulingService {
    private int counter;

    @Scheduled(cron = "*/2 * * * * *")
    public void cronService() {
        System.out.println("Lol " + ++counter);
    }
}
