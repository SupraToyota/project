package com.official_dealer.demo.mapper;

import com.official_dealer.demo.dto.DealerDTO;
import com.official_dealer.demo.entity.Dealer;

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
