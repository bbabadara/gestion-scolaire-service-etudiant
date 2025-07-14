package com.ecole221.gestion.etudiant.repository;

import com.ecole221.gestion.etudiant.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByNom(String nom);

}
