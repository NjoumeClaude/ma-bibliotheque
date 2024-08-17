package com.adacorp.ma_bibliotheque.repositories;

import com.adacorp.ma_bibliotheque.models.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRepository  extends CrudRepository<Validation, Integer> {

    Optional<Validation> findBycode(String code);
}
