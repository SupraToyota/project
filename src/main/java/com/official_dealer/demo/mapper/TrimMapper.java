package com.official_dealer.demo.mapper;

import com.official_dealer.demo.dto.TrimDTO;
import com.official_dealer.demo.entity.Trim;

public final class TrimMapper {

    private TrimMapper() {}

    public static TrimDTO toDto(Trim trim) {
        return new TrimDTO(
                trim.getId(),
                trim.getName(),
                trim.getModel().getId()
        );
    }
}

