package com.database.MPT.controller.admin;

import com.database.MPT.model.Adresy;
import com.database.MPT.services.AdresyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin/adresy")
//@Secured("ROLE_ADMIN")
public class AdresyControllerAdmin {
    private final AdresyService adresyService;


    @PutMapping
    public ModelAndView updateAdresy(
            @RequestParam Integer id,
            //@RequestParam(required = false) String ulica
            @ModelAttribute Adresy adres
    ) {
        adresyService.updateAdresy(id, adres);
        return new ModelAndView("redirect:/showAdresy");
    }

    @Autowired
    public AdresyControllerAdmin(AdresyService adresyService) {
        this.adresyService = adresyService;
    }

    @GetMapping
    public List<Adresy> getAdresy() {
        System.out.println("kurwa");
        return adresyService.getAdresy();
    }

    @PostMapping
    public void registerNewAdresy(@RequestBody Adresy adres) {
        adresyService.addNewAdresy(adres);
    }

    @DeleteMapping()
    public void deleteAdres(@RequestParam("id") Integer id) {
        adresyService.deleteAdresy(id);
    }



}
