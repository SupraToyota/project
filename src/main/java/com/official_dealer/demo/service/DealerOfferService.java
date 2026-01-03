package com.official_dealer.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.official_dealer.demo.entity.Dealer;
import com.official_dealer.demo.entity.DealerOffer;
import com.official_dealer.demo.entity.Model;
import com.official_dealer.demo.repository.DealerOfferRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class DealerOfferService {

    private final DealerOfferRepository offerRepository;

    public DealerOfferService(DealerOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<DealerOffer> getOffersByDealer(Dealer dealer) {
        return offerRepository.findByDealer(dealer);
    }

    public List<DealerOffer> getOffersByModel(Model model) {
        return offerRepository.findByModel(model);
    }

    public DealerOffer createOffer(Dealer dealer, Model model,
                                   Integer releaseYear, String generationName, 
                                   Integer stockQuantity, BigDecimal price) {
        DealerOffer offer = new DealerOffer(dealer, model, null, releaseYear, generationName, stockQuantity, price);
        return offerRepository.save(offer);
    }

    public DealerOffer updateStock(DealerOffer offer, Integer newStock) {
        offer.setStockQuantity(newStock);
        return offerRepository.save(offer);
    }

    public DealerOffer updatePrice(DealerOffer offer, BigDecimal newPrice) {
        offer.setPrice(newPrice);
        return offerRepository.save(offer);
    }

    public DealerOffer getById(Long id) {
        return offerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Offer not found"));
    }



}
