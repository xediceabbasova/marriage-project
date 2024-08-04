package com.company.marriageproject.controller;

import com.company.marriageproject.dto.request.CreateWeddingAttachRequest;
import com.company.marriageproject.service.WeddingAttachService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attach")
public class WeddingAttachController {

    private final WeddingAttachService weddingAttachService;

    public WeddingAttachController(WeddingAttachService weddingAttachService) {
        this.weddingAttachService = weddingAttachService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createWeddingAttach(@RequestBody CreateWeddingAttachRequest request) {
        weddingAttachService.createWeddingAttach(request);
    }
}
