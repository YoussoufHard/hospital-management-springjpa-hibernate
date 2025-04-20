package ma.enset.jpa_hibernate_demo.repositories;

import ma.enset.jpa_hibernate_demo.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
