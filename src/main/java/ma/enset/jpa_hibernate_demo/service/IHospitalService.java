package ma.enset.jpa_hibernate_demo.service;

import ma.enset.jpa_hibernate_demo.entities.Consultation;
import ma.enset.jpa_hibernate_demo.entities.Medecin;
import ma.enset.jpa_hibernate_demo.entities.Patient;
import ma.enset.jpa_hibernate_demo.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRDV(RendezVous rendezVous);
}
