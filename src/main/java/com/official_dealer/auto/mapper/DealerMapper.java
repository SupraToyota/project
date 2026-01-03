package com.official_dealer.auto.mapper;

import com.official_dealer.auto.dto.DealerDTO;
import com.official_dealer.auto.entity.Dealer;

public final class DealerMapper {

    private DealerMapper() {}

    public static DealerDTO toDto(Dealer dealer) {
        return new DealerDTO(
                dealer.getId(),
                dealer.getName(),
                dealer.getPhone(),
                dealer.getAddress(),
                dealer.getLatitude(),
                dealer.getLongitude()
        );
    }
}
