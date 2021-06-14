package com.PermisPiste.entity;

import javax.persistence.*;


@Entity
public class Action {
    private int id;
    private String wording;
    private Integer scoreMinimum;

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

    @Basic
    @Column(name = "scoreMinimum", nullable = true)
    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (id != action.id) return false;
        if (wording != null ? !wording.equals(action.wording) : action.wording != null) return false;
        if (scoreMinimum != null ? !scoreMinimum.equals(action.scoreMinimum) : action.scoreMinimum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (scoreMinimum != null ? scoreMinimum.hashCode() : 0);
        return result;
    }
}
