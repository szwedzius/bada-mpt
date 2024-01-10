package com.database.MPT.repository;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.model.PracownicyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracownicyRepository extends JpaRepository<Pracownicy, Integer> {

    @Query("SELECT NEW com.database.MPT.model.PracownicyDto(p.id_pracownika, p.koniec_umowy," +
            "p.id_biura, p.id_zajezdni, p.id_stanowiska) FROM Pracownicy p")
    List<PracownicyDto> findForEmployee(int id);
}
