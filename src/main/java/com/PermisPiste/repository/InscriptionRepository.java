package com.PermisPiste.repository;

import com.PermisPiste.entity.Inscription;
import com.PermisPiste.entity.InscriptionAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    @Query(value = "SELECT * FROM inscription WHERE fk_learner = ?1", nativeQuery = true)
    List<Inscription> getInscriptionOfLearner(Integer learner_id);
}
