package com.adacorp.ma_bibliotheque.models;

import com.adacorp.ma_bibliotheque.TypeDeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;
    @Enumerated(EnumType.STRING)
    private TypeDeRole libelle;
}
