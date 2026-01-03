package com.official_dealer.auto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official_dealer.auto.entity.Model;
import com.official_dealer.auto.entity.Trim;
import com.official_dealer.auto.repository.TrimRepository;

import java.util.List;

@Service
@Transactional
public class TrimService {

    private final TrimRepository trimRepository;

    public TrimService(TrimRepository trimRepository) {
        this.trimRepository = trimRepository;
    }

    public List<Trim> getTrimsByModel(Model model) {
        return trimRepository.findByModel(model);
    }

    public Trim getById(Long id) {
        return trimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Trim not found"));
    }

    public Trim createTrim(Model model, String name) {
        Trim trim = new Trim(model, name);
        return trimRepository.save(trim);
    }
}
