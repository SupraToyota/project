package com.official_dealer.auto.mapper;

import com.official_dealer.auto.dto.TrimDTO;
import com.official_dealer.auto.entity.Trim;

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

