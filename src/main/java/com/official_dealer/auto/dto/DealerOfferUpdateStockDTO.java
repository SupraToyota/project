package com.official_dealer.auto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DealerOfferUpdateStockDTO(

        @NotNull
        @Min(0)
        Integer stockQuantity
) {}
