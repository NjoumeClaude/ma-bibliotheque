package com.adacorp.ma_bibliotheque.repositories;

import com.adacorp.ma_bibliotheque.models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateurs, Integer> {

}
