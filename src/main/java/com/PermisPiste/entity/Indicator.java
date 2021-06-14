package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name = "indicator")
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName="id")
    private Action fk_action;

    @NotNull
    @Column(name = "wording", nullable = true, length = 50)
    private String wording;

    @Column(nullable = true, name = "valueIfCheck")
    private Integer valueIfCheck;

    @Column(nullable = true, name = "valueIfUnCheck")
    private Integer valueIfUnCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getFk_action() {
        return fk_action;
    }

    public void setFk_action(Action fk_action) {
        this.fk_action = fk_action;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }
}
