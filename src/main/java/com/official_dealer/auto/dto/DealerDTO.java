package com.official_dealer.auto.dto;

public record DealerDTO(
        Long id,
        String name,
        String phone,
        String address,
        Double latitude,
        Double longitude
) {

}
