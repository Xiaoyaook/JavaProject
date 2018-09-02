package com.example.localcachemanager.healthcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 主启动类，负责初始化闭锁，然后等待，直到所有服务被检测完。
 *
 * created by xiaoyaook on 18-9-2
 */
public class ApplicationStartupUtil {

    // 服务检查者的列表
    private static List<com.example.localcachemanager.healthcheck.BaseHealthChecker> services;

    // 闭锁
    private static CountDownLatch latch;

    private ApplicationStartupUtil() {}

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception {
        // 初始化闭锁,参数为我们要检验的服务的数量
        latch = new CountDownLatch(3);

        services = new ArrayList<com.example.localcachemanager.healthcheck.BaseHealthChecker>();
        services.add(new com.example.localcachemanager.healthcheck.NetworkHealthChecker(latch));
        services.add(new com.example.localcachemanager.healthcheck.DatabaseHealthChecker(latch));
        services.add(new com.example.localcachemanager.healthcheck.CacheHealthChecker(latch));

        Executor executor = Executors.newFixedThreadPool(services.size());

        for (final com.example.localcachemanager.healthcheck.BaseHealthChecker v : services) {
            executor.execute(v);
        }

        latch.await();

        for (final com.example.localcachemanager.healthcheck.BaseHealthChecker v : services) {
            if (!v.isServiceUp()) {
                return false;
            }
        }
        return true;
    }

}
