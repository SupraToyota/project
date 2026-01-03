package com.official_dealer.auto.controller;

import org.springframework.web.bind.annotation.*;

import com.official_dealer.auto.dto.*;
import com.official_dealer.auto.mapper.*;
import com.official_dealer.auto.service.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Admin", description = "Admin management API")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final DealerService dealerService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final TrimService trimService;

    public AdminController(
            DealerService dealerService,
            BrandService brandService,
            ModelService modelService,
            TrimService trimService
    ) {
        this.dealerService = dealerService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.trimService = trimService;
    }

    /* -------- DEALERS -------- */

    @GetMapping("/dealers")
    public List<DealerDTO> allDealers() {
        return dealerService.getAllDealers()
                .stream()
                .map(DealerMapper::toDto)
                .toList();
    }

    @PatchMapping("/dealers/{id}/approve")
    public void approveDealer(@PathVariable Long id) {
        dealerService.approveDealer(id);
    }

    @PatchMapping("/dealers/{id}/disable")
    public void disableDealer(@PathVariable Long id) {
        dealerService.disableDealer(id);
    }

    /* -------- BRANDS -------- */

    @PostMapping("/brands")
    public BrandDTO createBrand(@RequestBody BrandDTO dto) {
        return BrandMapper.toDto(
                brandService.createBrand(dto.name(), dto.logoPath())
        );
    }

    /* -------- MODELS -------- */

    @PostMapping("/brands/{brandId}/models")
    public ModelDTO createModel(
            @PathVariable Long brandId,
            @RequestParam String name
    ) {
        var brand = brandService.getById(brandId);
        return ModelMapper.toDto(
                modelService.createModel(brand, name)
        );
    }

    /* -------- TRIMS -------- */

    @PostMapping("/models/{modelId}/trims")
    public TrimDTO createTrim(
            @PathVariable Long modelId,
            @RequestParam String name
    ) {
        var model = modelService.getById(modelId);
        return TrimMapper.toDto(
                trimService.createTrim(model, name)
        );
    }
}
