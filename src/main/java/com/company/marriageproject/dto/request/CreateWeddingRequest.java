package com.company.marriageproject.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public record CreateWeddingRequest(
        String name,
        LocalDateTime weddingDate,
        List<GuestAttachRequest> existingGuests
) {
}
