package com.official_dealer.auto.mapper;

import com.official_dealer.auto.dto.ModelDTO;
import com.official_dealer.auto.entity.Model;


public final class ModelMapper {

    private ModelMapper() {}

    public static ModelDTO toDto(Model model) {
        return new ModelDTO(
                model.getId(),
                model.getName(),
                model.getBrand().getId()
        );
    }
}

