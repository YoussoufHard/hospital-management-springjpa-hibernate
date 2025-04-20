package ma.enset.jpa_hibernate_demo.repositories;

import ma.enset.jpa_hibernate_demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
