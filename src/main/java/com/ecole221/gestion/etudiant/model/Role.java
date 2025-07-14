package com.ecole221.gestion.etudiant.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30)
    private String nom;

    @ManyToMany(mappedBy = "roles")
    private List<Utilisateur> Utilisateurs;

    public Role() {
    }

    public Role(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
