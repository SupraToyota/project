package com.official_dealer.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.official_dealer.demo.entity.Model;
import com.official_dealer.demo.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findByBrand(Brand brand);

    Optional<Model> findByBrandAndName(Brand brand, String name);

}
