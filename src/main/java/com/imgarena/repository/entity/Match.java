package com.imgarena.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    public Match() {}

    public Match(final String title) {
        this.title = title;
    }

    public Match(final int id, final String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
