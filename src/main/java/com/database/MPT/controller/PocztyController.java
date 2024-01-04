package com.database.MPT.controller;

import com.database.MPT.model.Poczty;
import com.database.MPT.services.PocztyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/poczty")
public class PocztyController {
    private final PocztyService pocztyService;

    @Autowired
    public PocztyController(PocztyService pocztyService) { this.pocztyService = pocztyService; }

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
