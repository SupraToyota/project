package com.official_dealer.demo.mapper;

import com.official_dealer.demo.dto.ModelDTO;
import com.official_dealer.demo.entity.Model;


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

