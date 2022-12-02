package com.system.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CafeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeSystemApplication.class, args);
    }

}
