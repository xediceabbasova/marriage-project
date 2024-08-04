package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.CreateGiftRequest;
import com.company.marriageproject.exception.GiftNotFoundException;
import com.company.marriageproject.model.Gift;
import com.company.marriageproject.repository.GiftRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GiftService {

    private final GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public void createGift(CreateGiftRequest request) {
        giftRepository.save(request.toGift());
    }

    @Cacheable(key = "#giftId", value = "gift")
    public Gift getGiftById(UUID giftId) {
        return giftRepository.findById(giftId)
                .orElseThrow(() -> new GiftNotFoundException("Gift not found"));
    }

}
