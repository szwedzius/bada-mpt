package com.database.MPT.services;

import com.database.MPT.model.Adresy;
import com.database.MPT.repository.AdresyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdresyService {
    private final AdresyRepository adresyRepository;
    @Autowired
    public AdresyService(AdresyRepository adresyRepository) {
        this.adresyRepository = adresyRepository;
    }
    public List<Adresy> getAdresy() {
        return adresyRepository.findAll();
    }

    public void addNewAdresy(Adresy adres) {
        /*String miasto = adres.getMiasto();
        String ulica = adres.getUlica();
        String budynek = adres.getNr_budynku();
        boolean check;
        Optional<Adresy> adresyOptional = adresyRepository.findByFields(adres);
        if (adresyOptional.isPresent()) {
          throw new IllegalStateException("ulica taken");
        }*/
        adresyRepository.save(adres);
    }

    public void deleteAdresy(Integer id) {
        boolean exists = adresyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("record with given id doesn't exist");
        }
        adresyRepository.deleteById(id);
    }
    @Transactional
    public void updateAdresy(Integer id, Adresy newAdres) {
        Optional<Adresy> optionalAdres = adresyRepository.findById(id);
        if (optionalAdres.isPresent()) {
            newAdres.setId_adresu(id);
            adresyRepository.save(newAdres);
        }
        else {
            throw new IllegalStateException("No address with given id!");
        }

    }
}
