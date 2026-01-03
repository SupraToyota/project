package com.official_dealer.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.official_dealer.demo.entity.Brand;
import com.official_dealer.demo.entity.Model;
import com.official_dealer.demo.entity.DealerOffer;
import com.official_dealer.demo.service.BrandService;
import com.official_dealer.demo.service.ModelService;
import com.official_dealer.demo.service.DealerOfferService;

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

    /** Список всех брендов */
    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    /** Список моделей конкретного бренда */
    @GetMapping("/brands/{brandId}/models")
    public List<Model> getModelsByBrand(@PathVariable Long brandId) {
        return brandService.getBrandByName(brandService.getAllBrands()
                        .stream()
                        .filter(b -> b.getId().equals(brandId))
                        .findFirst()
                        .map(Brand::getName)
                        .orElseThrow(() -> new RuntimeException("Brand not found")))
                .map(brand -> modelService.getModelsByBrand(brand))
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    /** Список предложений для модели */
    @GetMapping("/models/{modelId}/offers")
    public List<DealerOffer> getOffersByModel(@PathVariable Long modelId) {
        Model model = modelService.getModelByBrandAndName(
                modelService.getModelsByBrand(modelService.getModelsByBrand(
                        brandService.getAllBrands().get(0) // заглушка, будет переделано для нормального поиска
                ).get(0).getBrand(), "") // заглушка
        ).orElseThrow(() -> new RuntimeException("Model not found"));

        return offerService.getOffersByModel(model);
    }
}

