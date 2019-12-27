package com.calculator.Database.Logging.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserActionEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String action;

    public UserActionEntity() {
    }

    public UserActionEntity(String name, String action) {
        super();
        this.name = name;
        this.action = action;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalculation() {
        return action;
    }

    public void setCalculation(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "UserActionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
