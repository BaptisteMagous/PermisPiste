package com.PermisPiste.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name="learner")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "surname", nullable = true, length = 25)
    private String surname;

    @NotNull
    @Column(name = "forname", nullable = true, length = 25)
    private String forname;

    @NotNull
    @Column(name = "salt", nullable = true, length = 25)
    private String salt;

    @NotNull
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @NotNull
    @Column(name = "mdp", nullable = true, length = 80)
    private String mdp;

    @NotNull
    @Column(name = "role", nullable = true, length = 25)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
