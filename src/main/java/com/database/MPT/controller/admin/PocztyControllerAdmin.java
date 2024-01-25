package com.database.MPT.controller.admin;

import com.database.MPT.model.Poczty;
import com.database.MPT.services.PocztyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin/poczty")
//@Secured("ROLE_ADMIN")
public class PocztyControllerAdmin {
    private final PocztyService pocztyService;

    @Autowired
    public PocztyControllerAdmin(PocztyService pocztyService) { this.pocztyService = pocztyService; }

    @GetMapping
    public List<Poczty> getPoczty() { return pocztyService.getPoczty(); }

    @PostMapping
    public ModelAndView newPocztyEntity(@ModelAttribute Poczty poczta) {
        pocztyService.newPocztyEntity(poczta);
        return new ModelAndView("redirect:/showPoczty");
    }

    @DeleteMapping
    public ModelAndView deletePoczty(@RequestParam("id") Integer id) {
        pocztyService.deletePoczty(id);
        return new ModelAndView("redirect:/showPoczty");
    }

    @PutMapping
    public ModelAndView updatePoczty(
            @RequestParam Integer id,
            @ModelAttribute Poczty poczta
    ) {
        pocztyService.updatePoczty(id, poczta);
        return new ModelAndView("redirect:/showPoczty");
    }
}
