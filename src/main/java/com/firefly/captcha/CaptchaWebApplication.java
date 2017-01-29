package com.firefly.captcha;

import com.firefly.captcha.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaptchaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{CaptchaWebApplication.class, JpaConfig.class}, args);
    }
}
