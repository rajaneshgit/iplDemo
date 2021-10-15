package io.javabrains.ipldashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IplDashboardApplication {

    public static void main(String[] args) {
        System.out.println("main method IplDashboardApplication started...");
        SpringApplication.run(IplDashboardApplication.class, args);
    }

}
