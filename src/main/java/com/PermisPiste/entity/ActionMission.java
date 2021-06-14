package com.PermisPiste.entity;

import javax.persistence.*;

@Entity
@Table(name = "action__mission", schema = "projetpermis")
@IdClass(ActionMissionPK.class)
public class ActionMission {
    private int fkAction;
    private int fkMission;

    @Id
    @Column(name = "fk_action", nullable = false)
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Id
    @Column(name = "fk_mission", nullable = false)
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

        ActionMission that = (ActionMission) o;

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
