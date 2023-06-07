package com.example.chatserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "Hello~!!\nI hope your Today to be HAPPY with ours!";
    }
}
