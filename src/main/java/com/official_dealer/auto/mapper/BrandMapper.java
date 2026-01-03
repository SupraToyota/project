package com.official_dealer.auto.mapper;

import com.official_dealer.auto.dto.BrandDTO;
import com.official_dealer.auto.entity.Brand;

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
