package com.lambton.insurance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("one")
    public String getAllQuestion() {
        return "Testing Controller";
    }

}
