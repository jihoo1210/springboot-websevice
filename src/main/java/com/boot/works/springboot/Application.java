package com.boot.works.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Auditing 활성화
@EnableJpaAuditing

// 스프링 부트의 자동 설정, Bean 읽기와 생성 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS(Web Application Service) 실행
        SpringApplication.run(Application.class, args);
    }
}
