package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.CreateWeddingAttachRequest;
import com.company.marriageproject.model.Gift;
import com.company.marriageproject.model.Wedding;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WeddingAttachService {

    private final WeddingService weddingService;
    private final GiftService giftService;

    public WeddingAttachService(WeddingService weddingService, GiftService giftService) {
        this.weddingService = weddingService;
        this.giftService = giftService;
    }

    @Transactional
    public void createWeddingAttach(CreateWeddingAttachRequest request) {
        Wedding wedding = weddingService.getWeddingById(request.weddingId());
        wedding.getWeddingGuests().stream()
                .filter(weddingGuest -> weddingGuest.getGuest().getId().equals(request.guestId()))
                .findFirst()
                .ifPresent(weddingGuest -> {
                    Gift gift = giftService.getGiftById(request.giftId());
                    weddingGuest.setGift(gift);
                    weddingGuest.setAmount(request.giftAmount());
                });
    }
}
