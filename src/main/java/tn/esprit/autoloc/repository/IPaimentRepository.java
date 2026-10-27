package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaimentRepository extends JpaRepository<Paiement,Long> {
}