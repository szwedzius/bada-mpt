package com.database.MPT.controller;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.services.PracownicyService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pracownicy")
public class PracownicyController {
    private final PracownicyService pracownicyService;
    @Autowired
    public PracownicyController(PracownicyService pracownicyService) { this.pracownicyService = pracownicyService; }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Pracownicy> getPracownicy() { return pracownicyService.getPracownicy(); }

    @PostMapping
    public void newPracownicyEntity(@RequestBody Pracownicy pracownik) { pracownicyService.newPracownicyEntity(pracownik); }

    @DeleteMapping(path = "{pracownikId}")
    public void deletePracownicy(@PathVariable("pracownikId") Integer id) {
        pracownicyService.deletePracownicy(id);
    }

    @PostMapping(path = "{pracownikId}")
    public void updatePracownicy(
            @PathVariable("pracownikId") Integer id,
            @RequestBody Pracownicy pracownik
    ) {
        pracownicyService.updatePracownicy(id, pracownik);
    }
}
