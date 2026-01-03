package com.official_dealer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.official_dealer.demo.entity.Dealer;

import java.util.Optional;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

    Optional<Dealer> findByEmail(String email);

}