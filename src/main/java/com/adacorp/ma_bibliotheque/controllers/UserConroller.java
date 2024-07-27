package com.adacorp.ma_bibliotheque.controllers;


import com.adacorp.ma_bibliotheque.dto.UserDto;
import com.adacorp.ma_bibliotheque.models.Utilisateurs;
import com.adacorp.ma_bibliotheque.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("utilisateur")
public class UserConroller {

    private final UserService userService;

    @PostMapping
    public UserDto newUser (@RequestBody UserDto dto) {

        return userService.creerUtilisateur(dto);
    }

    @GetMapping("afficher/{id}")
    public Utilisateurs getUserById(@PathVariable("id")   int identifiant){

        return userService.afficherUnUtilisateur(identifiant);
    }

    @GetMapping("afficher/all")
    public List<UserDto> listeDesUtilisateurs(){

        return userService.listeDesUtilisateurs();
    }



    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable("id")   int identifiant){

       userService.supprimerUtilisateur(identifiant);
    }
}
