package com.adacorp.ma_bibliotheque.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivreDto {

    private int idLivre;

    private String numIsbn;

    private String auteur;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate datePublication;

    private String editeur;

    private int nbreExemplaires;

    private String Categorie;
}
