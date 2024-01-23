package com.database.MPT.controller.employee;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.model.PracownicyDto;
import com.database.MPT.services.PracownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee/pracownicy")
@Secured("ROLE_USER")
public class PracownicyControllerEmployee {
    private final PracownicyService pracownicyService;
    @Autowired
    public PracownicyControllerEmployee(PracownicyService pracownicyService) { this.pracownicyService = pracownicyService; }

    @GetMapping
    public List<com.database.MPT.model.PracownicyDto> getPracownicy(@AuthenticationPrincipal User user) {
        return pracownicyService.getPracownicyForEmployee(user);
        //return "siema, kurwa";
    }

    @PostMapping(path = "{pracownikId}")
    public void updatePracownicy(
            @AuthenticationPrincipal User user,
            @PathVariable("pracownikId") Integer id,
            @RequestBody Pracownicy pracownik
    ) {
        pracownicyService.updatePracownicyForEmployee(user, id, pracownik);
    }
}
