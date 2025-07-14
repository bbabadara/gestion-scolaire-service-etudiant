package com.ecole221.gestion.etudiant.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantInscriptionRequest {
    private String matricule;
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50")
    private String nom;
    @Size(max = 100, message = "Le prénom ne doit pas dépasser 100")
    private String prenom;
    @Email(message = "L'email doit être valide")
    @Size(max = 100, message = "L'email ne doit pas dépasser")
    private String email;
    @Size(max = 15, message = "Le téléphone ne doit pas dépasser 15 caractères")
    @Pattern(regexp = "^(\\+221)?(77|78|70|76|75)\\d{7}$", message = "Le téléphone doit être un numéro valide sénégalais")
    private String telephone;
    private String adresse;
    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateNaissance;
    private String lieuNaissance;
}


