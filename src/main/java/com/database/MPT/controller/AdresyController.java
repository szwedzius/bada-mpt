package com.database.MPT.controller;

import com.database.MPT.model.Adresy;
import com.database.MPT.services.AdresyService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/adresy")
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
public class AdresyController {
    private final AdresyService adresyService;

    @Autowired
    public AdresyController(AdresyService adresyService) {
        this.adresyService = adresyService;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<Adresy> getAdresy() {
        return adresyService.getAdresy();
    }

    @PostMapping
    public void registerNewAdresy(@RequestBody Adresy adres) {
        adresyService.addNewAdresy(adres);
    }

    @DeleteMapping(path = "{adresId}")
    public void deleteAdres(@PathVariable("adresId") Integer id) {
        adresyService.deleteAdresy(id);
    }

    @PutMapping(path = "{adresId}")
    public void updateAdresy(
            @PathVariable("adresId") Integer id,
            //@RequestParam(required = false) String ulica
            @RequestBody Adresy adres
    ) {
        adresyService.updateAdresy(id, adres);
    }
}
