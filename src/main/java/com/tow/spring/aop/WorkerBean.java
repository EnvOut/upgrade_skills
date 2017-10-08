package com.tow.spring.aop;

public class WorkerBean {
    public void dpSomeWork(int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            work();
        }
    }

    private void work() {
        System.out.println("");
    }
}
