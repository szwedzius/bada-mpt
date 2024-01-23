package com.database.MPT.repository;

import com.database.MPT.model.Adresy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresyRepository extends JpaRepository<Adresy, Integer> {
    @Query("SELECT a FROM Adresy a WHERE a.id_adresu = :id")
    Adresy findAddressById(int id);
}
