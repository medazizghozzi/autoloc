package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("contrats")
@RestController

public class ContratRestController {

    private final IContratService contratService;

    @PostMapping
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @GetMapping("{id}")
    public Contrat getContrat(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @GetMapping
    public List<Contrat> getContrat() {
        return contratService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        contratService.deleteById(id);
    }

    @PutMapping("{id}")
    public Contrat update(@PathVariable Long id, @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }
}