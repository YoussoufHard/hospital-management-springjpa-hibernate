package ma.enset.jpa_hibernate_demo.service;

import ma.enset.jpa_hibernate_demo.entities.Consultation;
import ma.enset.jpa_hibernate_demo.entities.Medecin;
import ma.enset.jpa_hibernate_demo.entities.Patient;
import ma.enset.jpa_hibernate_demo.entities.RendezVous;
import ma.enset.jpa_hibernate_demo.repositories.ConsultationRepository;
import ma.enset.jpa_hibernate_demo.repositories.MedecinRepository;
import ma.enset.jpa_hibernate_demo.repositories.PatientRepository;
import ma.enset.jpa_hibernate_demo.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
}
