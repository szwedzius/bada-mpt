package com.database.MPT.services;

import com.database.MPT.model.Poczty;
import com.database.MPT.repository.PocztyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PocztyService {
    private final PocztyRepository pocztyRepository;

    @Autowired
    public PocztyService(PocztyRepository pocztyRepository) { this.pocztyRepository = pocztyRepository; }

    public List<Poczty> getPoczty() { return pocztyRepository.findAll(); }

    public void newPocztyEntity(Poczty poczta) {
        Optional<Poczty> pocztyOptional = pocztyRepository.findByKod(poczta.getKod_pocztowy());
        if (pocztyOptional.isPresent()) {
            throw new IllegalStateException("aaa");
        }
        if(poczta.getKod_pocztowy() != null && poczta.getKod_pocztowy().length() == 6) {
            pocztyRepository.save(poczta);
        }
    }

    public void deletePoczty(Integer id) {
        boolean exists = pocztyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("record with given id doesn't exist");
        }
        pocztyRepository.deleteById(id);
    }

    @Transactional
    public void updatePoczty(Integer id, Poczty newPoczta) {
        Optional<Poczty> optionalPoczta = pocztyRepository.findById(id);
        if (optionalPoczta.isPresent()) {
            newPoczta.setId_poczty(id);
            pocztyRepository.save(newPoczta);
        }
        else {
            throw new IllegalStateException("No post office with given id!");
        }
    }
}
