package com.company.marriageproject.repository;

import com.company.marriageproject.model.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeddingRepository extends JpaRepository<Wedding, UUID> {
}
