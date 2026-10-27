package tn.esprit.autoloc.service.impls;

import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.exceptions.ResourceNotFound;
import tn.esprit.autoloc.repository.IPaimentRepository;
import tn.esprit.autoloc.service.IPaimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaimentServiceImpl implements IPaimentService {

    public final IPaimentRepository paimentRepository;

    @Override
    public Paiement findById (Long id) {
        return paimentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Paiement", id));
    }

    @Override
    public List<Paiement> findAll() {
        return paimentRepository.findAll();
    }
}