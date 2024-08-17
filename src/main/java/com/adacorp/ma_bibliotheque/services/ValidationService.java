package com.adacorp.ma_bibliotheque.services;

import com.adacorp.ma_bibliotheque.models.Logins;
import com.adacorp.ma_bibliotheque.models.Validation;
import com.adacorp.ma_bibliotheque.repositories.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@AllArgsConstructor
@Service
public class ValidationService {
    private ValidationRepository validationRepository;
    private NotificationService notificationService;

    public void enregistrer(Logins logins) {
        Validation validation = new Validation();
        validation.setLogins(logins);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExpire(expiration);
        Random random = new Random();
        Integer randomInt = random.nextInt(999999);
        String code = String.format("%06d", randomInt);
        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);
    }

    public Validation lireEnFonctionDuCode(String code) {
      return   this.validationRepository.findBycode(code).orElseThrow(()
                -> new RuntimeException("votre code est invalide"));
    }
}
