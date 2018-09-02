package com.example.localcachemanager.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * created by xiaoyaook on 18-9-2
 */
public class CacheHealthChecker extends com.example.localcachemanager.healthcheck.BaseHealthChecker {
    public CacheHealthChecker (CountDownLatch latch) {
        super("Cache Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
