package com.PermisPiste.repository;

import com.PermisPiste.entity.InscriptionAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionActionRepository extends JpaRepository<InscriptionAction, Integer> {
    @Query(value = "SELECT * FROM inscription__action WHERE fk_inscription = ?1", nativeQuery = true)
    List<InscriptionAction>  getActionDuringInscription(Integer fk_inscription);
}
