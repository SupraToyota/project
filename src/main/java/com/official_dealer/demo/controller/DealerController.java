package com.official_dealer.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.official_dealer.demo.entity.*;
import com.official_dealer.demo.service.*;

import java.math.BigDecimal;
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

    /**
     * Получить все свои предложения
     */
    @GetMapping("/offers")
    public List<DealerOffer> getMyOffers(@RequestAttribute Dealer dealer) {
        return offerService.getOffersByDealer(dealer);
    }

    /**
     * Создать новое предложение
     */
    @PostMapping("/offers")
    public DealerOffer createOffer(
            @RequestAttribute Dealer dealer,
            @RequestParam Long modelId,
            @RequestParam(required = false) Long trimId,
            @RequestParam Integer releaseYear,
            @RequestParam(required = false) String generationName,
            @RequestParam Integer stockQuantity,
            @RequestParam BigDecimal price
    ) {
        Model model = modelService.getById(modelId);
        Trim trim = (trimId != null) ? trimService.getById(trimId) : null;

        return offerService.createOffer(
                dealer,
                model,
                trim,
                releaseYear,
                generationName,
                stockQuantity,
                price
        );
    }

    /**
     * Обновить количество в наличии
     */
    @PatchMapping("/offers/{offerId}/stock")
    public DealerOffer updateStock(
            @PathVariable Long offerId,
            @RequestParam Integer stock
    ) {
        DealerOffer offer = offerService.getById(offerId);
        return offerService.updateStock(offer, stock);
    }

    /**
     * Обновить цену
     */
    @PatchMapping("/offers/{offerId}/price")
    public DealerOffer updatePrice(
            @PathVariable Long offerId,
            @RequestParam BigDecimal price
    ) {
        DealerOffer offer = offerService.getById(offerId);
        return offerService.updatePrice(offer, price);
    }
}

