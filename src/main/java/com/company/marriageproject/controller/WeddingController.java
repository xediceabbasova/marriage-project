package com.company.marriageproject.controller;

import com.company.marriageproject.dto.request.CreateWeddingRequest;
import com.company.marriageproject.service.WeddingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wedding")
public class WeddingController {

    private final WeddingService weddingService;

    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @PostMapping
    public void createWedding(@RequestBody CreateWeddingRequest weddingRequest) {
        weddingService.createWedding(weddingRequest);
    }
}
