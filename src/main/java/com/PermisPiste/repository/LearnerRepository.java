package com.PermisPiste.repository;

import com.PermisPiste.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    @Query(value = "SELECT * FROM learner WHERE forname = ?1 LIMIT 1", nativeQuery = true)
    Learner findByName(String forname);
}
