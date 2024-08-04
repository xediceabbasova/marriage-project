package com.company.marriageproject.dto.request;

import com.company.marriageproject.model.Guest;

public record CreateGuestRequest(
        String name,
        String surname
) {
    public Guest toGuest() {
        return Guest.builder()
                .name(name)
                .surname(surname)
                .build();
    }
}
