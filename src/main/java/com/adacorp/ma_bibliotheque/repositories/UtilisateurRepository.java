package com.adacorp.ma_bibliotheque.repositories;

import com.adacorp.ma_bibliotheque.models.Logins;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Logins, Integer> {

   Optional<Logins> findByUsername(String username);
}
