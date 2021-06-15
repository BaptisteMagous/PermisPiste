package com.PermisPiste.repository;

import com.PermisPiste.entity.Action;
import com.PermisPiste.entity.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, Integer> {
    @Query(value = "SELECT * FROM indicator WHERE fk_action = ?1", nativeQuery = true)
    List<Indicator> getIndicatorsOfAction(Integer fk_action);
}
