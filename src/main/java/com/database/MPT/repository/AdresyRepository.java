package com.database.MPT.repository;

import com.database.MPT.model.Adresy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresyRepository extends JpaRepository<Adresy, Integer> {
    /*@Query("SELECT a FROM Adresy a WHERE (a.ulica = ?1 AND a.miasto = ?2 AND a.nr_budynku = ?3)")
    Optional<Adresy> findByFields(Adresy adres);*/
}
