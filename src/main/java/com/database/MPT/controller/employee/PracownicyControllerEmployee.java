package com.database.MPT.controller.employee;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.model.PracownicyDto;
import com.database.MPT.services.PracownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee/pracownicy")

public class PracownicyControllerEmployee {
    private final PracownicyService pracownicyService;
    @Autowired
    public PracownicyControllerEmployee(PracownicyService pracownicyService) { this.pracownicyService = pracownicyService; }

    @GetMapping
    public Pracownicy getPracownicy() {
        return pracownicyService.getUserPracownik().get(1);
    }

    @PutMapping
    public ModelAndView updatePracownicy(
            @RequestParam Integer id,
            @ModelAttribute Pracownicy pracownik
    ) {
        pracownicyService.updatePracownicyForAdmin(id, pracownik);
        return new ModelAndView("redirect:/user");
    }
}
