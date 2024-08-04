package com.adacorp.ma_bibliotheque.dto;

import com.adacorp.ma_bibliotheque.enums.EnumAbonnement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbonnementDto {

    private int numAbonnement;

    private LocalDate dateAbonnement;

    private LocalDate dateExpiration;

    private EnumAbonnement typeAbonnement;

    private String statutAbonnement;
}
