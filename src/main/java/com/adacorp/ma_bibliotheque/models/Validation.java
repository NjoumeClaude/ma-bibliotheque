package com.adacorp.ma_bibliotheque.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "validation")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer validationId;
    private Instant creation;
    private Instant expire;
    private Instant activation;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private Logins logins;
}
