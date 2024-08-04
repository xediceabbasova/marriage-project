package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.CreateGuestRequest;
import com.company.marriageproject.repository.GuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void createGuest(CreateGuestRequest request) {
        guestRepository.save(request.toGuest());
    }
}
