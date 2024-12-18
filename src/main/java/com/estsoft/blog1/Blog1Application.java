package com.estsoft.blog1;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@SpringBootApplication
public class Blog1Application {

    public static void main(String[] args) {
        SpringApplication.run(Blog1Application.class, args);
    }

}
