package com.database.MPT.repository;

import com.database.MPT.model.Poczty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PocztyRepository extends JpaRepository<Poczty, Integer> {
    @Query("SELECT p FROM Poczty p WHERE p.kod_pocztowy = ?1")
    Optional<Poczty> findByKod(String kod);
}
