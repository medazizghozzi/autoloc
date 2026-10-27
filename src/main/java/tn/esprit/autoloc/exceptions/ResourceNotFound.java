package tn.esprit.autoloc.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String resource, long id) {
        super(resource + " introuvable avec l'identifiant " + id);
    }
}
