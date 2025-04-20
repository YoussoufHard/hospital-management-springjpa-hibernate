package ma.enset.jpa_hibernate_demo.web;

import ma.enset.jpa_hibernate_demo.entities.Patient;
import ma.enset.jpa_hibernate_demo.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientRestController {
    private final PatientRepository patientRepository;

    public PatientRestController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Consulter tous les patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Consulter un patient par ID
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Chercher un patient par nom
    @GetMapping("/search")
    public Patient searchByName(@RequestParam String nom) {
        return patientRepository.findByNom(nom);
    }

    // Ajouter un patient
    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // Mettre à jour un patient
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        updatedPatient.setId(id);
        return patientRepository.save(updatedPatient);
    }

    // Supprimer un patient
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
