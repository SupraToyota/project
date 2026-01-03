package com.official_dealer.demo.dto;

import java.math.BigDecimal;

public record DealerOfferResponseDTO(
    Long id,
    Long dealerId,
    String dealerName,
    Long modelId,
    String modelName,
    Long trimId,
    String trimName,
    Integer releaseYear,
    String generationName,
    Integer stockQuantity,
    BigDecimal price
) {

}
