package com.official_dealer.auto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official_dealer.auto.entity.Brand;
import com.official_dealer.auto.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandByName(String name) {
        return brandRepository.findByName(name);
    }

    public Brand createBrand(String name, String logoPath) {
        Brand brand = new Brand(name, logoPath);
        return brandRepository.save(brand);
    }

    public Brand getById(Long id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

}
