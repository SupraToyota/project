package com.official_dealer.demo.dto;

import java.math.BigDecimal;

public record DealerOfferCreateRequestDTO(
    Long modelId,
    Long trimId,           // optional
    Integer releaseYear,
    String generationName, // optional
    Integer stockQuantity,
    BigDecimal price
) {

}
