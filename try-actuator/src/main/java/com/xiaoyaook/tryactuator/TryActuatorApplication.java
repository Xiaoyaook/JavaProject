package com.xiaoyaook.tryactuator;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class TryActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryActuatorApplication.class, args);
    }
}
