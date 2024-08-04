package com.company.marriageproject.controller;

import com.company.marriageproject.dto.request.CreateGiftRequest;
import com.company.marriageproject.service.GiftService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createGift(@RequestBody CreateGiftRequest request) {
        giftService.createGift(request);
    }
}
