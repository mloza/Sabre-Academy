package com.sabre.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Michal
 * 2014-11-18.
 */
@Entity
public class Task implements Serializable {
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    @Lob
    private String description;

    @Column
    private Double budget;

    @Column
    private Boolean done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Task withId(final Long id) {
        this.id = id;
        return this;
    }

    public Task withName(final String name) {
        this.name = name;
        return this;
    }

    public Task withDescription(final String description) {
        this.description = description;
        return this;
    }

    public Task withBudget(final Double budget) {
        this.budget = budget;
        return this;
    }

    public Task withDone(final Boolean done) {
        this.done = done;
        return this;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", done=" + done +
                '}';
    }
}
