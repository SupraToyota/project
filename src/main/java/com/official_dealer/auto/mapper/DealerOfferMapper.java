package com.official_dealer.auto.mapper;

import com.official_dealer.auto.dto.DealerOfferResponseDTO;
import com.official_dealer.auto.entity.DealerOffer;
import com.official_dealer.auto.entity.Trim;

public final class DealerOfferMapper {
        private DealerOfferMapper() {}

    public static DealerOfferResponseDTO toResponseDto(DealerOffer offer) {

        Trim trim = offer.getTrim();

        return new DealerOfferResponseDTO(
                offer.getId(),
                offer.getDealer().getId(),
                offer.getDealer().getName(),
                offer.getModel().getId(),
                offer.getModel().getName(),
                trim != null ? trim.getId() : null,
                trim != null ? trim.getName() : null,
                offer.getReleaseYear(),
                offer.getGenerationName(),
                offer.getStockQuantity(),
                offer.getPrice()
        );
    }

}
