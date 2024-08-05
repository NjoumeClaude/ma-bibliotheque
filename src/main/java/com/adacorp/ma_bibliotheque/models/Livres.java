package com.adacorp.ma_bibliotheque.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Livres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLivre;

    private String numIsbn;

    private String auteur;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate datePublication;

    private String editeur;

    private int nbreExemplaires;

    private String Categorie;
}
