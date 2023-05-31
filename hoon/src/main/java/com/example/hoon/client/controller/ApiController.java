package com.example.hoon.client.controller;

import com.example.hoon.client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService service;

    public ApiController(RestTemplateService service) {
        this.service = service;
    }

    @GetMapping
    public String getHello() {
        return "Client: " + this.service.hello();
    }
}
