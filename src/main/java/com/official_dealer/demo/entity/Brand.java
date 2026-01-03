package com.official_dealer.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "brands",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
    }
)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "logo_path", length = 255)
    private String logoPath;

    @OneToMany(
        mappedBy = "brand",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<Model> models;

    // --- constructors ---

    protected Brand() {
        // for JPA
    }

    public Brand(String name, String logoPath) {
        this.name = name;
        this.logoPath = logoPath;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
