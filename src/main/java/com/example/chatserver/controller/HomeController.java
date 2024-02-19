package com.example.chatserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "Hello~!!😀😀😀😀😀I hope your Today to be HAPPY with ours!";
    }
}
