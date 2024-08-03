package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.CreateWeddingRequest;
import com.company.marriageproject.repository.GuestRepository;
import com.company.marriageproject.repository.WeddingRepository;
import org.springframework.stereotype.Service;

@Service
public class WeddingService {

    private final WeddingRepository weddingRepository;
    private final GuestRepository guestRepository;

    public WeddingService(WeddingRepository weddingRepository, GuestRepository guestRepository) {
        this.weddingRepository = weddingRepository;
        this.guestRepository = guestRepository;
    }

    public void createWedding(CreateWeddingRequest weddingRequest) {
    }
}
