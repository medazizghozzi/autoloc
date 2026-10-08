package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false, length = 50)
    private String adresse;
    @Column(nullable = false, length = 8)
    private int telephone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "agence",fetch=FetchType.LAZY)
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "agence",fetch=FetchType.LAZY)
    private List<Vehicule> vehicules = new ArrayList<>();
}
