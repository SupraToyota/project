package com.official_dealer.demo.controller;
// stroka 49
import org.springframework.web.bind.annotation.*;
import com.official_dealer.demo.dto.*;
import com.official_dealer.demo.mapper.DealerOfferMapper;
import com.official_dealer.demo.entity.Dealer;
import com.official_dealer.demo.service.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/dealer")
public class DealerController {

    private final DealerOfferService offerService;
    private final ModelService modelService;
    private final TrimService trimService;

    public DealerController(DealerOfferService offerService,
                            ModelService modelService,
                            TrimService trimService) {
        this.offerService = offerService;
        this.modelService = modelService;
        this.trimService = trimService;
    }

    /** Мои предложения */
    @GetMapping("/offers")
    public List<DealerOfferResponseDTO> myOffers(@RequestAttribute Dealer dealer) {
        return offerService.getOffersByDealer(dealer)
                .stream()
                .map(DealerOfferMapper::toResponseDto)
                .toList();
    }

    /** Создать предложение */
    @PostMapping("/offers")
    public DealerOfferResponseDTO createOffer(
            @RequestAttribute Dealer dealer,
            @Valid @RequestBody DealerOfferCreateRequestDTO dto
    ) {
        var model = modelService.getById(dto.modelId());
        var trim = dto.trimId() != null ? trimService.getById(dto.trimId()) : null;

        var offer = offerService.createOffer(
                dealer,
                model,
                dto.releaseYear(),
                //!trim,----------------------------------------------------------------------------------------------------
                dto.generationName(),
                dto.stockQuantity(),
                dto.price()
        );

        return DealerOfferMapper.toResponseDto(offer);
    }

    /** Обновить остаток */
    @PatchMapping("/offers/{offerId}/stock")
    public DealerOfferResponseDTO updateStock(
            @PathVariable Long offerId,
            @Valid @RequestBody DealerOfferUpdateStockDTO dto
    ) {
        var offer = offerService.getById(offerId);
        return DealerOfferMapper.toResponseDto(
                offerService.updateStock(offer, dto.stockQuantity())
        );
    }

    /** Обновить цену */
    @PatchMapping("/offers/{offerId}/price")
    public DealerOfferResponseDTO updatePrice(
            @PathVariable Long offerId,
            @Valid @RequestBody DealerOfferUpdatePriceDTO dto
    ) {
        var offer = offerService.getById(offerId);
        return DealerOfferMapper.toResponseDto(
                offerService.updatePrice(offer, dto.price())
        );
    }
}
