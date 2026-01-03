package com.official_dealer.auto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.official_dealer.auto.entity.Brand;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

}

