package com.adacorp.ma_bibliotheque.services.impl;

import com.adacorp.ma_bibliotheque.dto.UserDto;
import com.adacorp.ma_bibliotheque.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImplUserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldSaveUserWithSuccess() {

        //Arrange or given
        UserDto expectedUser = UserDto.builder()
                .identifiant(0)
                .nom("njoume")
                .prenom("Claude")
                .email("njoumeclaude@yahoo.fr")
                .motDePass("adidas")
                .build();

        //Act or when
        UserDto savedUser = userService.creerUtilisateur(expectedUser);

        //Assert or then
        assertNotNull(savedUser);
        assertEquals(expectedUser, savedUser);
        assertEquals(expectedUser.getNom(), savedUser.getNom());
        assertEquals(expectedUser.getPrenom(), savedUser.getPrenom());
        assertEquals(expectedUser.getEmail(), savedUser.getEmail());
        assertEquals(expectedUser.getMotDePass(), savedUser.getMotDePass());

    }
}