package com.boot.works.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// JSON을 반환하는 컨트롤러
// 자동적으로 @ResponseBody를 각 메소드에 선언한다고 생각하면 된다
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
