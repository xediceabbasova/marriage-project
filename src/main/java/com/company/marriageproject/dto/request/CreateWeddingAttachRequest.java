package com.company.marriageproject.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateWeddingAttachRequest(
        UUID weddingId,
        UUID guestId,
        UUID giftId,
        BigDecimal giftAmount
) {
}
