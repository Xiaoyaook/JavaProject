package com.example.localcachemanager.healthcheck;

/**
 * created by xiaoyaook on 18-9-2
 */
public class Main {
    public static void main(String[] args)
    {
        boolean result = false;
        try {
            result = com.example.localcachemanager.healthcheck.ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("外部服务验证完成！！ 结果为 :: "+ result);
    }
}
