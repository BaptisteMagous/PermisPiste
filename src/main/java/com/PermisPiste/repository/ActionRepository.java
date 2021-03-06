package com.PermisPiste.repository;

import com.PermisPiste.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query(value = "SELECT A.* FROM action A JOIN action__mission AM ON A.id = AM.fk_action WHERE AM.fk_mission = ?1", nativeQuery = true)
    List<Action> getActionOfMission(Integer fk_mission);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM action__mission WHERE fk_action = ?1", nativeQuery = true)
    void deleteActionMissionLinkedTo(Integer fk_action);
}
