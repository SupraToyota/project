package com.official_dealer.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.official_dealer.demo.entity.Brand;
import com.official_dealer.demo.entity.Model;
import com.official_dealer.demo.repository.ModelRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> getModelsByBrand(Brand brand) {
        return modelRepository.findByBrand(brand);
    }

    public Optional<Model> getModelByBrandAndName(Brand brand, String name) {
        return modelRepository.findByBrandAndName(brand, name);
    }

    public Model createModel(Brand brand, String name) {
        Model model = new Model(brand, name);
        return modelRepository.save(model);
    }

    public Model getById(Long id) {
        return modelRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Model not found"));
    }

}
