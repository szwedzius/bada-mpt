package com.database.MPT.controller.admin;

import com.database.MPT.model.Poczty;
import com.database.MPT.services.PocztyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin/poczty")
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
@Secured("ROLE_ADMIN")
public class PocztyControllerAdmin {
    private final PocztyService pocztyService;

    @Autowired
    public PocztyControllerAdmin(PocztyService pocztyService) { this.pocztyService = pocztyService; }

    @GetMapping
    public List<Poczty> getPoczty() { return pocztyService.getPoczty(); }

    @PostMapping
    public void newPocztyEntity(@RequestBody Poczty poczta) {
        pocztyService.newPocztyEntity(poczta);
    }

    @DeleteMapping(path = "{pocztaId}")
    public void deletePoczty(@PathVariable("pocztaId") Integer id) {
        pocztyService.deletePoczty(id);
    }

    @PutMapping(path = "{pocztaId}")
    public void updatePoczty(
            @PathVariable("pocztaId") Integer id,
            @RequestBody Poczty poczta
    ) {
        pocztyService.updatePoczty(id, poczta);
    }
}
