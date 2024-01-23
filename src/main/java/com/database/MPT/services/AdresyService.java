package com.database.MPT.services;

import com.database.MPT.model.Adresy;
import com.database.MPT.model.Pracownicy;
import com.database.MPT.repository.AdresyRepository;
import com.database.MPT.repository.PracownicyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdresyService {
    private final AdresyRepository adresyRepository;
    private final PracownicyRepository pracownicyRepository;
    @Autowired
    public AdresyService(AdresyRepository adresyRepository) {
        this.adresyRepository = adresyRepository;
    }
    @Autowired
    public PracownicyService(PracownicyRepository pracownicyRepository) { this.pracownicyRepository = pracownicyRepository; }
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
    public void updateAdresyforAdmin(Integer id, Adresy newAdres) {
        Optional<Adresy> optionalAdres = adresyRepository.findById(id);
        if (optionalAdres.isPresent()) {
            newAdres.setId_adresu(id);
            adresyRepository.save(newAdres);
        }
        else {
            throw new IllegalStateException("No address with given id!");
        }
    }

    @Transactional
    public void updateAdresyforEmployee(User user, Integer id, Adresy newAdres) {
        // Checking role
        Collection<GrantedAuthority> authoritiesList = user.getAuthorities();
        String authority = authoritiesList.iterator().next().getAuthority();
        int SenderId = Character.getNumericValue(authority.charAt(authority.length() - 1));
        // Checking if record exists
        Optional<Adresy> optionalAdres = adresyRepository.findById(id);
        Pracownicy pracownik_user = PracownicyRepository.find
        if (optionalAdres.isPresent() && newAdres.getId_adresu() ==  ) {
            newAdres.setId_adresu(id);
            adresyRepository.save(newAdres);
        }
        else {
            throw new IllegalStateException("No address with given id!");
        }
    }
}
