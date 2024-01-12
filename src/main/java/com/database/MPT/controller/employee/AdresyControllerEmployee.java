package com.database.MPT.controller.employee;

import com.database.MPT.model.Adresy;
import com.database.MPT.services.AdresyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee/adresy")
@Secured("ROLE_USER")
public class AdresyControllerEmployee {
    private final AdresyService adresyService;

    @Autowired
    public AdresyControllerEmployee(AdresyService adresyService) {
        this.adresyService = adresyService;
    }

    @GetMapping
    public List<Adresy> getAdresy() {
        return adresyService.getAdresy();
    }

    @PostMapping
    public void registerNewAdresy(@RequestBody Adresy adres) {
        adresyService.addNewAdresy(adres);
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
