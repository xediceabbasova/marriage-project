package com.company.marriageproject.service;

import com.company.marriageproject.dto.request.CreateWeddingRequest;
import com.company.marriageproject.dto.request.GuestAttachRequest;
import com.company.marriageproject.exception.WeddingNotFoundException;
import com.company.marriageproject.model.Wedding;
import com.company.marriageproject.model.WeddingGuest;
import com.company.marriageproject.repository.GuestRepository;
import com.company.marriageproject.repository.WeddingRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WeddingService {

    private final WeddingRepository weddingRepository;
    private final GuestRepository guestRepository;

    public WeddingService(WeddingRepository weddingRepository, GuestRepository guestRepository) {
        this.weddingRepository = weddingRepository;
        this.guestRepository = guestRepository;
    }

    public void createWedding(CreateWeddingRequest weddingRequest) {

        List<WeddingGuest> weddingGuests = weddingRequest.existingGuests().stream()
                .map(GuestAttachRequest::guestId)
                .map(guestRepository::findById)
                .flatMap(Optional::stream)
                .map(guest -> WeddingGuest.builder().guest(guest).build())
                .collect(Collectors.toList());

        weddingRepository.save(Wedding.builder()
                .name(weddingRequest.name())
                .weddingDate(weddingRequest.weddingDate())
                .weddingGuests(weddingGuests)
                .build());
    }

    @Cacheable(key = "#weddingId", value = "wedding")
    public Wedding getWeddingById(UUID weddingId) {
        return weddingRepository.findById(weddingId)
                .orElseThrow(() -> new WeddingNotFoundException("Wedding not found"));
    }
}
