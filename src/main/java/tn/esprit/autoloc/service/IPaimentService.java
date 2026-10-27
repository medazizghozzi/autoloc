package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaimentService {
    Paiement findById (Long id);
    List<Paiement> findAll();
}