package ma.enset.jpa_hibernate_demo;

import ma.enset.jpa_hibernate_demo.entities.*;
import ma.enset.jpa_hibernate_demo.repositories.ConsultationRepository;
import ma.enset.jpa_hibernate_demo.repositories.MedecinRepository;
import ma.enset.jpa_hibernate_demo.repositories.PatientRepository;
import ma.enset.jpa_hibernate_demo.repositories.RendezVousRepository;
import ma.enset.jpa_hibernate_demo.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            RendezVousRepository rendezVousRepository,
            MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Youssouf","Hassan" ,"Najat","Salma")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Ayman","Hajar" ,"Yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient= patientRepository.findById(1L).orElse(null);
            Patient patient2= patientRepository.findByNom("Youssouf");

            Medecin medecin= medecinRepository.findByNom("Yasmine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1= rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la Consultation ...");
            hospitalService.saveConsultation(consultation);

        } ;
    }

}