package com.company.marriageproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Gift gift;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Guest guest;

    private BigDecimal amount;
}
