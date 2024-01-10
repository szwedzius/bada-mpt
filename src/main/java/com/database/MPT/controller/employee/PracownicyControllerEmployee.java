package com.database.MPT.controller.employee;

import com.database.MPT.services.PracownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/employee/pracownicy")
//@EnableMethodSecurity(
//        securedEnabled = false,
//        jsr250Enabled = true)
//@Secured("ROLE_USER")
public class PracownicyControllerEmployee {
    private final PracownicyService pracownicyService;
    @Autowired
    public PracownicyControllerEmployee(PracownicyService pracownicyService) { this.pracownicyService = pracownicyService; }

    @GetMapping
    public String getPracownicy(/*@AuthenticationPrincipal User user*/) {
        //return pracownicyService.getPracownicyForEmployee(user);
        return "siema, kurwa";
    }

    /*@PostMapping(path = "{pracownikId}")
    public void updatePracownicy(
            @PathVariable("pracownikId") Integer id,
            @RequestBody Pracownicy pracownik
    ) {
        pracownicyService.updatePracownicyForEmployee(id, pracownik);
    }*/
}
