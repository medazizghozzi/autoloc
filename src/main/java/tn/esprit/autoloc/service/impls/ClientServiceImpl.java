package tn.esprit.autoloc.service.impls;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.exceptions.ResourceNotFound;
import tn.esprit.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        if (client.getIdClient() != null) {
            throw new IllegalArgumentException("Un nouveau client ne doit pas avoir d'identifiant");
        }
        verifier(client);
        return clientRepository.save(client);
    }

    @Override
    public Client findById (Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Client", id));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFound("Client", id);
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Long id, Client client) {
        Client existant = findById(id);
        verifier(client);
        existant.setNom(client.getNom());
        existant.setPrenom(client.getPrenom());
        existant.setEmail(client.getEmail());
        existant.setTelephone(client.getTelephone());
        existant.setNumPermis(client.getNumPermis());
        existant.setDateInscription(client.getDateInscription());
        return clientRepository.save(existant);
    }

    private void verifier(Client client) {
        if (client.getNom() == null || client.getNom().isBlank()
                || client.getEmail() == null || client.getEmail().isBlank()) {
            throw new IllegalArgumentException("Le nom et l'e-mail du client sont obligatoires");
        }
    }
}