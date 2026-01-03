package com.official_dealer.demo.mapper;

import com.official_dealer.demo.dto.BrandDTO;
import com.official_dealer.demo.entity.Brand;

public final class BrandMapper {

    private BrandMapper() {
    }

    public static BrandDTO toDto(Brand brand) {
        return new BrandDTO(
                brand.getId(),
                brand.getName(),
                brand.getLogoPath());
    }
}
