package com.database.MPT.services;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.repository.PracownicyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PracownicyService {
    private final PracownicyRepository pracownicyRepository;

    @Autowired
    public PracownicyService(PracownicyRepository pracownicyRepository) {
        this.pracownicyRepository = pracownicyRepository;
    }

    public List<Pracownicy> getPracownicyForAdmin() {
        return pracownicyRepository.findAll();
    }
    public List<com.database.MPT.model.PracownicyDto> getPracownicyForEmployee(User user) {
        Collection<GrantedAuthority> authoritiesList = user.getAuthorities();
        String authority = authoritiesList.iterator().next().getAuthority();
        int id = Character.getNumericValue(authority.charAt(authority.length() - 1));
        return pracownicyRepository.findForEmployee(id);
        //return pracownicyRepository.findAll();
    }

    public List<Pracownicy> getUserPracownik(){
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
    public void updatePracownicyForAdmin(Integer id, Pracownicy newPracownik) {
        Optional<Pracownicy> optionalPoczta = pracownicyRepository.findById(id);
        if (optionalPoczta.isPresent()) {
            newPracownik.setId_pracownika(id);
            pracownicyRepository.save(newPracownik);
        }
        else {
            throw new IllegalStateException("No post worker with given id!");
        }
    }

    @Transactional
    public void updatePracownicyForEmployee(Integer id, Pracownicy newPracownik) {
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
