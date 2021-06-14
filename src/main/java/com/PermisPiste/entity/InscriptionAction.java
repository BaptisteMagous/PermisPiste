package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name = "inscription__action")
public class InscriptionAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_inscription", referencedColumnName="id")
    private Inscription fk_inscription;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName="id")
    private Action fk_action;

    @Column(nullable = true, name = "sort")
    private Integer sort;

    @Column(nullable = true, name = "score")
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Inscription getFk_inscription() {
        return fk_inscription;
    }

    public void setFk_inscription(Inscription fk_inscription) {
        this.fk_inscription = fk_inscription;
    }

    public Action getFk_action() {
        return fk_action;
    }

    public void setFk_action(Action fk_action) {
        this.fk_action = fk_action;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
