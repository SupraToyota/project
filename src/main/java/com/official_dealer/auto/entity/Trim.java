package com.official_dealer.auto.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "trims",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"model_id", "name"})
    }
)
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active = true;

    // --- constructors ---

    protected Trim() {
    }

    public Trim(Model model, String name) {
        this.model = model;
        this.name = name;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
