package com.adacorp.ma_bibliotheque.controllers;

import com.adacorp.ma_bibliotheque.models.Logins;
import com.adacorp.ma_bibliotheque.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateursController {

    private UtilisateurService utilisateurService;

    @PostMapping("inscription")
    public void inscription(@RequestBody Logins logins) {
        log.info("Inscription");
        this.utilisateurService.inscription(logins);
    }

    @PostMapping("activation")
    public void activation(@RequestBody Map<String,String> activation) {
        log.info("Inscription");
        this.utilisateurService.activation(activation);
    }
}
