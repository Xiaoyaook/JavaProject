package com.example.localcachemanager.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * created by xiaoyaook on 18-9-2
 */
public abstract class BaseHealthChecker implements Runnable {

    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    /**
     * 在构造函数中传入一个latch，使得当任务结束时，线程可以对latch对象执行countDown()
     *
     * @param serviceName
     * @param latch
     */
    public BaseHealthChecker(String serviceName, CountDownLatch latch) {
        super();
        this.latch = latch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace();
            serviceUp = false;
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    /**
     * 所有继承类实现该方法，完成服务的检查
     */
    public abstract void verifyService();
}
