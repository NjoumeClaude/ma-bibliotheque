package com.adacorp.ma_bibliotheque.models;

import com.adacorp.ma_bibliotheque.enums.EnumAbonnement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abonnements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numAbonnement;

    private LocalDate dateAbonnement;

    private LocalDate dateExpiration;

    private EnumAbonnement typeAbonnement;

    private String statutAbonnement;

}
