package com.qiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启对filter 的支持
@SpringBootApplication
public class Web1Application {

    public static void main(String[] args) {
        SpringApplication.run(Web1Application.class, args);
    }

}
