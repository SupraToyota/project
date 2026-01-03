package com.official_dealer.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(
    name = "dealer_offers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dealer_id", "model_id", "trim_id", "release_year", "generation_name"})
    }
)
public class DealerOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Дилер, который выставил предложение */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;

    /** Модель авто */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    /** Комплектация (может быть null) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trim_id")
    private Trim trim;

    /** Год выпуска автомобиля */
    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    /** Поколение модели (может быть null) */
    @Column(name = "generation_name")
    private String generationName;

    /** Количество автомобилей в наличии */
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    /** Цена авто */
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    /** Время создания / обновления записи */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(nullable = false)
    private ZonedDateTime updatedAt = ZonedDateTime.now();

    // --- constructors ---

    protected DealerOffer() {
    }

    public DealerOffer(Dealer dealer, Model model, Trim trim,
                       Integer releaseYear, String generationName,
                       Integer stockQuantity, BigDecimal price) {
        this.dealer = dealer;
        this.model = model;
        this.trim = trim;
        this.releaseYear = releaseYear;
        this.generationName = generationName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenerationName() {
        return generationName;
    }

    public void setGenerationName(String generationName) {
        this.generationName = generationName;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}