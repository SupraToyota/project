package com.official_dealer.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(
    name = "models",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"brand_id", "name"})
    }
)
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active = true;

    // --- constructors ---

    protected Model() {
    }

    public Model(Brand brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

