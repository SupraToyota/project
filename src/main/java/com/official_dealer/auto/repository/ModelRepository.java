package com.official_dealer.auto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.official_dealer.auto.entity.Brand;
import com.official_dealer.auto.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findByBrand(Brand brand);

    Optional<Model> findByBrandAndName(Brand brand, String name);

}
