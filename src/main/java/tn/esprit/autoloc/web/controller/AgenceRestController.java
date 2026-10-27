package tn.esprit.autoloc.web.controller;


import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("agences")
@RestController
public class AgenceRestController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence add(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @GetMapping("{id}")
    public Agence getAgence(@PathVariable Long id) {
        return agenceService.findById(id);
    }

    @GetMapping
    public List<Agence> getAgence() {
        return agenceService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        agenceService.deleteById(id);
    }

    @PutMapping("{id}")
    public Agence update(@PathVariable Long id, @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }
}