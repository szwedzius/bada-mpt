package com.database.MPT.controller.admin;

import com.database.MPT.model.Pracownicy;
import com.database.MPT.services.PracownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin/pracownicy")
//@Secured("ROLE_ADMIN")
public class PracownicyControllerAdmin {
    private final PracownicyService pracownicyService;
    @Autowired
    public PracownicyControllerAdmin(PracownicyService pracownicyService) { this.pracownicyService = pracownicyService; }

    @GetMapping
    public List<Pracownicy> getPracownicy() { return pracownicyService.getPracownicyForAdmin(); }

    @PostMapping
    public void newPracownicyEntity(@RequestBody Pracownicy pracownik) { pracownicyService.newPracownicyEntity(pracownik); }

    @DeleteMapping(path = "{pracownikId}")
    public void deletePracownicy(@PathVariable("pracownikId") Integer id) {
        pracownicyService.deletePracownicy(id);
    }

    @PutMapping
    public ModelAndView updatePracownicy(
            @RequestParam Integer id,
            @ModelAttribute Pracownicy pracownik
    ) {
        pracownicyService.updatePracownicyForAdmin(id, pracownik);
        return new ModelAndView("redirect:/showPracownicy");
    }
}
