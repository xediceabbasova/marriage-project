package com.company.marriageproject.repository;

import com.company.marriageproject.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiftRepository extends JpaRepository<Gift, UUID> {
}
