# Spring Boot JPA Hibernate Project - Hospital Management

## Description
Ce projet utilise Spring Boot avec JPA et Hibernate pour la gestion d'une application de **gestion des patients** dans un hôpital. Les entités principales incluent **Patient**, **RendezVous** (rendez-vous médicaux), et **Medecin** (médecin).

L'application utilise **H2** comme base de données en mémoire pour faciliter le développement et les tests, mais peut être facilement migrée vers **MySQL** pour un environnement de production.

## Technologies Utilisées
- **Spring Boot 3.x**
- **JPA / Hibernate**
- **Lombok** (pour générer des getters/setters et autres méthodes)
- **H2 Database** (pour l'environnement de développement)
- **MySQL** (facultatif pour la production)

## Prérequis
Avant de lancer l'application, assurez-vous d'avoir installé les éléments suivants :
- **JDK 17+**
- **Maven** (ou **Gradle** selon le choix de ton projet)
- **IDE comme IntelliJ IDEA** pour le développement (optionnel mais recommandé)

## Installation

### Cloner le projet
```bash
git clone https://github.com/ton-compte/nom-du-repository.git
```

### Lancer l'application
1. Ouvrir le projet dans votre IDE préféré (IntelliJ, Eclipse, etc.)
2. Exécuter la classe principale (celle annotée avec `@SpringBootApplication`).
3. L'application sera lancée à l'adresse suivante : [http://localhost:8086](http://localhost:8086).

## Architecture du Projet
- **Entities :**
    - **Patient** : Contient les informations sur les patients (nom, date de naissance, malade, etc.).
    - **RendezVous** : Représente un rendez-vous entre un patient et un médecin.
    - **Medecin** : Contient les informations sur les médecins (nom, email, spécialité).
    - **Consultation** : Représente une consultation médicale, associée à un `RendezVous`. Elle contient la date de la consultation et un rapport médical.

- **Base de données :**
    - L'application utilise une **base H2 en mémoire** pour le développement et peut être facilement migrée vers **MySQL** pour un environnement de production.

## Fonctionnalités
Voici les principales fonctionnalités que l'application gère :
- **Ajout de patients** : Ajouter un patient avec ses informations.
- **Consultation des patients** : Lister tous les patients ou consulter un patient spécifique.
- **Gestion des rendez-vous** : Créer, consulter et modifier les rendez-vous entre un patient et un médecin.
- **Gestion des médecins** : Ajouter et gérer des médecins.

## Tests et Validation
Les entités et les relations ont été validées en utilisant la base H2 en mémoire.

- Après avoir exécuté l'application, les tables sont visibles dans la console H2 [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
- La création et la mise à jour des entités sont automatiquement effectuées grâce à la configuration `ddl-auto=update`.
- voici la capture de la console h2
  ![Capture Console H2](/Captures/img.png)


## Améliorations Futures
- Migration vers **MySQL** pour un environnement de production.
- Ajout d'une interface utilisateur avec **Thymeleaf** ou **React** pour interagir avec l'application.
- Ajouter une authentification avec **Spring Security**.
