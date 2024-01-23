package com.database.MPT.services;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.repository.PracownicyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
        Optional<Pracownicy> optionalPracownicy = pracownicyRepository.findById(id);
        if (optionalPracownicy.isPresent()) {
            newPracownik.setId_pracownika(id);
            pracownicyRepository.save(newPracownik);
        }
        else {
            throw new IllegalStateException("No worker with given id!");
        }
    }

    @Transactional
    public void updatePracownicyForEmployee(User user, Integer id, Pracownicy newPracownik) {
        // Checking role
        Collection<GrantedAuthority> authoritiesList = user.getAuthorities();
        String authority = authoritiesList.iterator().next().getAuthority();
        int SenderId = Character.getNumericValue(authority.charAt(authority.length() - 1));
        // Checking if record exists
        Optional<Pracownicy> optionalPracownicy = pracownicyRepository.findById(id);
        // Further verification
        if (optionalPracownicy.isPresent() &&
                SenderId == id &&
                pracownicyCheck(id, newPracownik)) {
            newPracownik.setId_pracownika(id);
            pracownicyRepository.save(newPracownik);
        }
        else {
            throw new IllegalStateException("No worker with given id!");
        }
    }

    // Worker can't update critical information about themselves
    private boolean pracownicyCheck(Integer id, Pracownicy newPracownik) {
        boolean check = false;
        Pracownicy record = pracownicyRepository.findPracownik(id);
        if (
            record.getId_pracownika() == newPracownik.getId_pracownika() &&
                    record.getPesel().equals(newPracownik.getPesel()) &&
                    record.getData_urodzenia().equals(newPracownik.getData_urodzenia()) &&
                    record.getId_stanowiska() == newPracownik.getId_stanowiska() &&
                    record.getKoniec_umowy().equals(newPracownik.getKoniec_umowy())
        ) { check = true; }
        return check;
    }
}
