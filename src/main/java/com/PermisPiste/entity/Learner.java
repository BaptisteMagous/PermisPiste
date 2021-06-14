package com.PermisPiste.entity;

import javax.persistence.*;
@Entity
public class Learner {
    private int id;
    private String surname;
    private String forname;
    private String salt;
    private String email;
    private String mdp;
    private String role;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 25)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "forname", nullable = true, length = 25)
    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 25)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mdp", nullable = true, length = 80)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 25)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Learner learner = (Learner) o;

        if (id != learner.id) return false;
        if (surname != null ? !surname.equals(learner.surname) : learner.surname != null) return false;
        if (forname != null ? !forname.equals(learner.forname) : learner.forname != null) return false;
        if (salt != null ? !salt.equals(learner.salt) : learner.salt != null) return false;
        if (email != null ? !email.equals(learner.email) : learner.email != null) return false;
        if (mdp != null ? !mdp.equals(learner.mdp) : learner.mdp != null) return false;
        if (role != null ? !role.equals(learner.role) : learner.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (forname != null ? forname.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
