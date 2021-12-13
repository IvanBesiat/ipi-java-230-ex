package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

    Employe findByMatricule(String matricule);
    List<Employe> findByNomAndPrenom(String nom, String prenom);
    List<Employe> findByNomIgnoreCase(String nom);
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double Salaire);
    @Query("SELECT e FROM employe e WHERE lower(e.prenom) = lower(:nomOuPrenom) OR lower(e.nom) = lower(:nomOuPrenom)")
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);
    @Query(value = "select * from employe " +
            "WHERE salaire > (select avg(e2.salaire) from employe e2)"
    , nativeQuery = true)
    List<Employe> findEmployePlusRiches();

}
