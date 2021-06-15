package com.PermisPiste.repository;

import com.PermisPiste.entity.ActionMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionMissionRepository extends JpaRepository<ActionMission, Integer> {
}
