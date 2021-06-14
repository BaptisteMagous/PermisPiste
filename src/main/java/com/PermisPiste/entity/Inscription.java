package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_learner", referencedColumnName="id")
    private Learner fk_learner;

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName="id")
    private Mission fk_mission;

    @Column(nullable = true, name = "date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Learner getFk_learner() {
        return fk_learner;
    }

    public void setFk_learner(Learner fk_learner) {
        this.fk_learner = fk_learner;
    }

    public Mission getFk_mission() {
        return fk_mission;
    }

    public void setFk_mission(Mission fk_mission) {
        this.fk_mission = fk_mission;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
