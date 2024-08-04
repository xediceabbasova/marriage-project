package com.company.marriageproject.dto.request;

import com.company.marriageproject.model.Gift;
import com.company.marriageproject.model.GiftType;

public record CreateGiftRequest(
        String parentName,
        String imageUrl,
        GiftType giftType
) {
    public Gift toGift() {
        return Gift.builder()
                .name(parentName)
                .giftType(giftType)
                .build();
    }
}
