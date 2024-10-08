package com.adacorp.ma_bibliotheque.services.impl;

import com.adacorp.ma_bibliotheque.dto.UserDto;
import com.adacorp.ma_bibliotheque.models.Abonnements;
import com.adacorp.ma_bibliotheque.models.Utilisateurs;
import com.adacorp.ma_bibliotheque.repositories.UserRepository;
import com.adacorp.ma_bibliotheque.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ImplUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto creerUtilisateur(UserDto dto) {

        Utilisateurs newUser = userRepository.save(UserDto.fromDto(dto));


        return UserDto.fromEntity(newUser);
    }

    @Override
    public List<UserDto> listeDesUtilisateurs() {

        List<Utilisateurs> utilisateur = userRepository.findAll();

        List<UserDto> listeAafficher = new ArrayList<>();

        for(Utilisateurs item: utilisateur){

            listeAafficher.add(UserDto.fromEntity(item));
        }

        return listeAafficher;
    }

    @Override
    public Utilisateurs afficherUnUtilisateur(int identifiant) {

        Utilisateurs utilisateurTrouve = userRepository.findById(identifiant)
                .orElseThrow(()->new EntityNotFoundException("aucun utilisateur trouvé avec l'identifiant "+identifiant));

        return utilisateurTrouve;
    }

    @Override
    public void supprimerUtilisateur(int identifiant) {

        userRepository.deleteById(identifiant);
    }

    ;
}
