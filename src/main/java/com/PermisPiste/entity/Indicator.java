package com.PermisPiste.entity;

import javax.persistence.*;
@Entity
public class Indicator {
    private int id;
    private String wording;
    private Integer valueIfCheck;
    private Integer valueIfUnCheck;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wording", nullable = true, length = 50)
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Basic
    @Column(name = "valueIfCheck", nullable = true)
    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    @Basic
    @Column(name = "valueIfUnCheck", nullable = true)
    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Indicator indicator = (Indicator) o;

        if (id != indicator.id) return false;
        if (wording != null ? !wording.equals(indicator.wording) : indicator.wording != null) return false;
        if (valueIfCheck != null ? !valueIfCheck.equals(indicator.valueIfCheck) : indicator.valueIfCheck != null)
            return false;
        if (valueIfUnCheck != null ? !valueIfUnCheck.equals(indicator.valueIfUnCheck) : indicator.valueIfUnCheck != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (valueIfCheck != null ? valueIfCheck.hashCode() : 0);
        result = 31 * result + (valueIfUnCheck != null ? valueIfUnCheck.hashCode() : 0);
        return result;
    }
}
