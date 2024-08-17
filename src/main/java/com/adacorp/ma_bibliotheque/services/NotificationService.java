package com.adacorp.ma_bibliotheque.services;

import com.adacorp.ma_bibliotheque.models.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService {
    JavaMailSender javaMailSender;

    public void envoyer(Validation validation) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("no-reply@gmail.com");
        mailMessage.setTo(validation.getLogins().getUsername());
        mailMessage.setSubject("votre code d'activation");
        String texte = String.format(
                "Bonjour %s, <br /> Votre code d'activation est %s, A bientôt",
                validation.getLogins().getNom(),
                validation.getCode()
        ); 
        mailMessage.setText(texte);
        javaMailSender.send(mailMessage);
    }
}
