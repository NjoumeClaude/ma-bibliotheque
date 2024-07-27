package com.adacorp.ma_bibliotheque.services;

import com.adacorp.ma_bibliotheque.dto.UserDto;
import com.adacorp.ma_bibliotheque.models.Utilisateurs;

import java.util.List;

public interface UserService {

   UserDto creerUtilisateur(UserDto dto);

   List<UserDto> listeDesUtilisateurs();

   Utilisateurs afficherUnUtilisateur(int identifiant);

   void supprimerUtilisateur (int identifiant);
}
