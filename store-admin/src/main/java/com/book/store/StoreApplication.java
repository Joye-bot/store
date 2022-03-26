package com.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用启动入口
 *
 * @author nndmw
 * @date 2022/02/19
 */
@RestController
@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @GetMapping(value = "/test")
    public String hello() {
        return "Hello World!";
    }

}
