package com.database.MPT.controller.employee;

import com.database.MPT.model.Poczty;
import com.database.MPT.services.PocztyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee/poczty")
@Secured("ROLE_USER")
public class PocztyControllerEmployee {
    private final PocztyService pocztyService;

    @Autowired
    public PocztyControllerEmployee(PocztyService pocztyService) { this.pocztyService = pocztyService; }

    @GetMapping
    public List<Poczty> getPoczty() { return pocztyService.getPoczty(); }

    @PostMapping
    public void newPocztyEntity(@RequestBody Poczty poczta) {
        pocztyService.newPocztyEntity(poczta);
    }
}
