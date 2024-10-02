package org.msync.spring_clj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "org.msync.spring_boost")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
