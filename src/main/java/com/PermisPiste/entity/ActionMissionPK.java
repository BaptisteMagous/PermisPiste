package com.PermisPiste.entity;

import java.io.Serializable;
import javax.persistence.*;

public class ActionMissionPK implements Serializable {
    private int fkAction;
    private int fkMission;

    @Column(name = "fk_action", nullable = false)
    @Id
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Column(name = "fk_mission", nullable = false)
    @Id
    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionMissionPK that = (ActionMissionPK) o;

        if (fkAction != that.fkAction) return false;
        if (fkMission != that.fkMission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fkAction;
        result = 31 * result + fkMission;
        return result;
    }
}
