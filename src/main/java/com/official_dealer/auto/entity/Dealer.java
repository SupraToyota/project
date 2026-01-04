package com.official_dealer.auto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_dealers", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "name" }),
        @UniqueConstraint(columnNames = { "email" })
})
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Официальное название дилера */
    @Column(nullable = false)
    private String name;

    /** Контактный email (используется и для входа) */
    @Column(nullable = false)
    private String email;

    /** Контактный телефон */
    @Column(nullable = false)
    private String phone;

    /** Физический адрес */
    @Column(nullable = false)
    private String address;

    /** Геолокация для карты */
    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    /** Аккаунт подтверждён администрацией */
    @Column(nullable = false)
    private boolean approved = false;

    /** Дилер активен / скрыт */
    @Column(nullable = false)
    private boolean active = true;

    // --- constructors ---

    protected Dealer() {
    }

    public Dealer(
            String name,
            String email,
            String phone,
            String address,
            Double latitude,
            Double longitude) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

