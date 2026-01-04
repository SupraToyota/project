package com.official_dealer.auto.entity;


import jakarta.persistence.*;

@Entity
@Table(
    name = "app_users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Email используется как логин */
    @Column(nullable = false)
    private String email;

    /** Хэш пароля (bcrypt и т.п.) */
    @Column(nullable = false)
    private String passwordHash;

    /** Роль пользователя */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /** Пользователь активен / заблокирован */
    @Column(nullable = false)
    private boolean active = true;

    /** К какому дилеру относится пользователь (null для ADMIN) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    // --- constructors ---

    protected User() {
    }

    public User(String email, String passwordHash, Role role, Dealer dealer) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.dealer = dealer;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
