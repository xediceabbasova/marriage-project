package com.company.marriageproject.dto.request;

import com.company.marriageproject.model.User;

public record UserRequest(
        String name,
        String surname
) {
    public User toUser() {
        return User.builder()
                .name(name)
                .surname(surname)
                .build();
    }
}

