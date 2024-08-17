package com.adacorp.ma_bibliotheque.services;

import com.adacorp.ma_bibliotheque.TypeDeRole;
import com.adacorp.ma_bibliotheque.models.Logins;
import com.adacorp.ma_bibliotheque.models.Role;
import com.adacorp.ma_bibliotheque.models.Validation;
import com.adacorp.ma_bibliotheque.repositories.UtilisateurRepository;
import com.adacorp.ma_bibliotheque.repositories.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private ValidationService validationService;


    public void inscription(Logins logins) {
        if (!logins.getUsername().contains("@")) {
            throw new RuntimeException("votre email est invalide");
        }

        if (!logins.getUsername().contains(".")) {
            throw new RuntimeException("votre email est invalide");
        }
      Optional<Logins> optionaluser = this.utilisateurRepository.findByUsername(logins.getUsername());
        if (optionaluser.isPresent()) {
            throw new RuntimeException("ce mail est déjà utilisé!!");
        }
        String mdpCrypt = this.passwordEncoder.encode(logins.getMdp());
        logins.setMdp(mdpCrypt);
        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        logins.setRole(roleUtilisateur);
     logins = this.utilisateurRepository.save(logins);
     this.validationService.enregistrer(logins);
    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpire())){
            throw new RuntimeException("votre code a expiré!");
        }
       Logins utilisateurActiver =  this.utilisateurRepository.findById(validation.getLogins().getId()).orElseThrow(()
                -> new RuntimeException("utilisateur inconnu"));
        utilisateurActiver.setActif(true);
        this.utilisateurRepository.save(utilisateurActiver);
    }
}
