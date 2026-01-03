package com.official_dealer.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.official_dealer.demo.entity.Brand;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

}

