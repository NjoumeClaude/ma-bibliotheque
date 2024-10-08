package com.adacorp.ma_bibliotheque.dto;

import com.adacorp.ma_bibliotheque.models.Utilisateurs;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int identifiant;

    private String nom;

    private String prenom;

    private String email;

    private String motDePass;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date_creation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date_edition;



    public static Utilisateurs fromDto (UserDto dto){


        return Utilisateurs.builder()
                .identifiant(dto.getIdentifiant())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .email(dto.getEmail())
                .motDePass(dto.getMotDePass())
                .date_creation(dto.getDate_creation())
                .date_edition(dto.getDate_edition())
                .build();

    }

    public static UserDto fromEntity (Utilisateurs utilisateurs){


        return UserDto.builder()
                .identifiant(utilisateurs.getIdentifiant())
                .nom(utilisateurs.getNom())
                .prenom(utilisateurs.getPrenom())
                .email(utilisateurs.getEmail())
                .motDePass(utilisateurs.getMotDePass())
                .date_creation(utilisateurs.getDate_creation())
                .date_edition(utilisateurs.getDate_edition())
                .build();

    }


}
