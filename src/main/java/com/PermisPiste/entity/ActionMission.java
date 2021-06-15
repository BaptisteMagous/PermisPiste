package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "action__mission")
public class ActionMission {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName="id")
    private Action fk_action;

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName="id")
    private Mission fk_mission;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Action getFk_action() {
        return fk_action;
    }

    public void setFk_action(Action fk_action) {
        this.fk_action = fk_action;
    }

    public Mission getFk_mission() {
        return fk_mission;
    }

    public void setFk_mission(Mission fk_mission) {
        this.fk_mission = fk_mission;
    }
}
