package com.adacorp.ma_bibliotheque.repositories;

import com.adacorp.ma_bibliotheque.models.Utilisateurs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void shouldReturnUserWhenIdIsFound(){

        //given
        Utilisateurs expectedUser = Utilisateurs.builder()
                .identifiant(0)
                .nom("NJOUME")
                .prenom("Claude")
                .email("njoumeclaude@gmail.com")
                .motDePass("adidas")
                .build();

        repository.save(expectedUser);

        //when
        Optional<Utilisateurs> userFound = repository.findById(0);

        //then
        assertThat(userFound.isPresent());
    }

}