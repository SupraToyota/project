package com.official_dealer.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.official_dealer.demo.entity.DealerOffer;
import com.official_dealer.demo.entity.Dealer;
import com.official_dealer.demo.entity.Model;

import java.util.List;

public interface DealerOfferRepository extends JpaRepository<DealerOffer, Long> {

    List<DealerOffer> findByDealer(Dealer dealer);

    List<DealerOffer> findByModel(Model model);

}
