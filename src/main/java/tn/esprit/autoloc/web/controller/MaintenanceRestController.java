package tn.esprit.autoloc.web.controller;


import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("maintenances")
@RestController

public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance add(@RequestBody Maintenance maintenance) {
        return maintenanceService.create(maintenance);
    }

    @GetMapping("{id}")
    public Maintenance getMaintenance(@PathVariable Long id) {
        return maintenanceService.findById(id);
    }

    @GetMapping
    public List<Maintenance> getMaintenance() {
        return maintenanceService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        maintenanceService.deleteById(id);
    }

    @PutMapping("{id}")
    public Maintenance update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }
}
