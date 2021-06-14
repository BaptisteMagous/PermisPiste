package com.PermisPiste.entity;

import javax.persistence.*;
@Entity
@Table(name = "inscription__action", schema = "projetpermis", catalog = "")
public class InscriptionAction {
    private int id;
    private Integer sort;
    private Integer score;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionAction that = (InscriptionAction) o;

        if (id != that.id) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
