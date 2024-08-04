package com.company.marriageproject.controller;

import com.company.marriageproject.dto.request.CreateGuestRequest;
import com.company.marriageproject.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createGuest(@RequestBody CreateGuestRequest request) {
        guestService.createGuest(request);
    }
}
