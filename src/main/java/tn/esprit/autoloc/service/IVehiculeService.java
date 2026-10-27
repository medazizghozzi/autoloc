package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create (Vehicule vehicule);
    Vehicule findById (Long id);
    List<Vehicule> findAll();
    void deleteById (Long id);
    Vehicule update (Long id, Vehicule vehicule);
}