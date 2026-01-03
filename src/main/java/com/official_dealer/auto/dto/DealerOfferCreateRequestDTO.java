package com.official_dealer.auto.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record DealerOfferCreateRequestDTO(

        @NotNull
        Long modelId,

        Long trimId, // optional

        @NotNull
        @Min(1900)
        @Max(2100)
        Integer releaseYear,

        @Size(max = 100)
        String generationName, // optional

        @NotNull
        @Min(0)
        Integer stockQuantity,

        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal price
) {}
