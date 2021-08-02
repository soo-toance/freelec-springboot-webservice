package com.toance.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json을 반환해주는 컨트롤러
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
