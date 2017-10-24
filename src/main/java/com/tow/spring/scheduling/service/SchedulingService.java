package com.tow.spring.scheduling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("schedulingService")
public class SchedulingService {
    private int msCounter;
    private int secondsCounter;

    @Async
//    @Scheduled(fixedDelay = 1L)
    public void cronService() {
        System.out.println("Lol " + ++msCounter);
    }

    @Async
//    @Scheduled(cron = "* * * * * *")
    public void fixedDelayService() {
        System.out.println("\n\n##############################Seconds " + ++secondsCounter);
    }

    @Async
    @Scheduled(fixedDelay = 1L)
    public void asyncService() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$asyncService " + ++msCounter);
    }
}
