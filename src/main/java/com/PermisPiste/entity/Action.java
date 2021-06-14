package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "wording", nullable = true, length = 25)
    private String wording;

    @Column(nullable = false, name = "scoreMinimum", columnDefinition = "int default 0")
    private Integer scoreMinimum;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName="id")
    private Action fk_action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    public Action getFk_action() {
        return fk_action;
    }

    public void setFk_action(Action fk_action) {
        this.fk_action = fk_action;
    }
}
