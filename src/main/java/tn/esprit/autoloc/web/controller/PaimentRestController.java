package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("paiements")
@RestController

public class PaimentRestController {

    private final IPaimentService paiementService;

    @GetMapping("{id}")
    public Paiement getPaiement(@PathVariable Long id) {
        return paiementService.findById(id);
    }

    @GetMapping
    public List<Paiement> getPaiement() {
        return paiementService.findAll();
    }
}
