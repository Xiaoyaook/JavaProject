package com.example.trycountdownlatch.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * created by xiaoyaook on 18-9-2
 */
public class DatabaseHealthChecker extends com.example.localcachemanager.healthcheck.BaseHealthChecker {

    public DatabaseHealthChecker (CountDownLatch latch) {
        super("Database Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
