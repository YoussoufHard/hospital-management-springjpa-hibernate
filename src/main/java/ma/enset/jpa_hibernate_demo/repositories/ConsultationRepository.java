package ma.enset.jpa_hibernate_demo.repositories;

import ma.enset.jpa_hibernate_demo.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
