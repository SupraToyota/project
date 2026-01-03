package com.official_dealer.auto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official_dealer.auto.entity.Dealer;
import com.official_dealer.auto.repository.DealerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DealerService {

    private final DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Optional<Dealer> getDealerByEmail(String email) {
        return dealerRepository.findByEmail(email);
    }

    public Dealer createDealer(String name, String email, String phone,
            String address, Double latitude, Double longitude) {
        Dealer dealer = new Dealer(name, email, phone, address, latitude, longitude);
        return dealerRepository.save(dealer);
    }

    public void approveDealer(Long dealerId) {
        var dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new IllegalArgumentException("Dealer not found"));
        dealer.setApproved(true);
    }

    public void disableDealer(Long dealerId) {
        var dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new IllegalArgumentException("Dealer not found"));
        dealer.setActive(false);
    }

}
