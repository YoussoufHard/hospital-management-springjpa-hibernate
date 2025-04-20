package ma.enset.jpa_hibernate_demo.repositories;

import ma.enset.jpa_hibernate_demo.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
