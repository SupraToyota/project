package com.official_dealer.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.official_dealer.demo.dto.*;
import com.official_dealer.demo.mapper.*;
import com.official_dealer.demo.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final BrandService brandService;
    private final ModelService modelService;
    private final DealerOfferService offerService;

    public PublicController(BrandService brandService,
                            ModelService modelService,
                            DealerOfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }

    /** Бренды */
    @GetMapping("/brands")
    public List<BrandDTO> brands() {
        return brandService.getAllBrands()
                .stream()
                .map(BrandMapper::toDto)
                .toList();
    }

    /** Модели бренда */
    @GetMapping("/brands/{brandId}/models")
    public List<ModelDTO> modelsByBrand(@PathVariable Long brandId) {
        var brand = brandService.getById(brandId);
        return modelService.getModelsByBrand(brand)
                .stream()
                .map(ModelMapper::toDto)
                .toList();
    }

    /** Предложения модели */
    @GetMapping("/models/{modelId}/offers")
    public List<DealerOfferResponseDTO> offersByModel(@PathVariable Long modelId) {
        var model = modelService.getById(modelId);
        return offerService.getOffersByModel(model)
                .stream()
                .map(DealerOfferMapper::toResponseDto)
                .toList();
    }
}
