package com.ecole221.gestion.etudiant.repository;


import com.ecole221.gestion.etudiant.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("""
        SELECT u 
        FROM Utilisateur u 
        JOIN FETCH u.roles 
        WHERE u.username = :username
        """)
    Optional<Utilisateur> findByUsernameWithRoles(String username);
}

