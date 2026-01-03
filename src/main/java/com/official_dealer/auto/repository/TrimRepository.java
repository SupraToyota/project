package com.official_dealer.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.official_dealer.auto.entity.Model;
import com.official_dealer.auto.entity.Trim;

import java.util.List;
import java.util.Optional;

public interface TrimRepository extends JpaRepository<Trim, Long> {

    List<Trim> findByModel(Model model);

    Optional<Trim> findByModelAndName(Model model, String name);

}