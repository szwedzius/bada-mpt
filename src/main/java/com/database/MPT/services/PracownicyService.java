package com.database.MPT.services;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.repository.PracownicyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracownicyService {
    private final PracownicyRepository pracownicyRepository;

    @Autowired
    public PracownicyService(PracownicyRepository pracownicyRepository) {
        this.pracownicyRepository = pracownicyRepository;
    }

    public List<Pracownicy> getPracownicy() {
        return pracownicyRepository.findAll();
    }

    public void newPracownicyEntity(Pracownicy pracownik) {
        pracownicyRepository.save(pracownik);
    }

    public void deletePracownicy(Integer id) {
        boolean exists = pracownicyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("record with given id doesn't exist");
        }
        pracownicyRepository.deleteById(id);
    }

    @Transactional
    public void updatePracownicy(Integer id, Pracownicy newPracownik) {
        Optional<Pracownicy> optionalPoczta = pracownicyRepository.findById(id);
        if (optionalPoczta.isPresent()) {
            newPracownik.setId_pracownika(id);
            pracownicyRepository.save(newPracownik);
        }
        else {
            throw new IllegalStateException("No post worker with given id!");
        }
    }
}
