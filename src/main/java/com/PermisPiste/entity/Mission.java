package com.PermisPiste.entity;

import javax.persistence.*;

@Entity
public class Mission {
    private int id;
    private String wording;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wording", nullable = true, length = 25)
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mission mission = (Mission) o;

        if (id != mission.id) return false;
        if (wording != null ? !wording.equals(mission.wording) : mission.wording != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        return result;
    }
}
