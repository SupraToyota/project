package com.official_dealer.auto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.official_dealer.auto.entity.Dealer;
import com.official_dealer.auto.entity.DealerOffer;
import com.official_dealer.auto.entity.Model;

import java.util.List;

public interface DealerOfferRepository extends JpaRepository<DealerOffer, Long> {

    List<DealerOffer> findByDealer(Dealer dealer);

    List<DealerOffer> findByModel(Model model);

}
