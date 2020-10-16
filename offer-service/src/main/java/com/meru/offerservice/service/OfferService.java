package com.meru.offerservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.meru.offerservice.model.Offer;
import com.meru.offerservice.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepo;

    @Autowired
    Environment env;

    public Offer addOffer(Offer req) {
        long randomId = new Date().getTime();
        String promoCode = Long.toString(randomId);
        req.setPromoCode("PROMO" + promoCode.substring(8));
        req.setOfferServicePort(env.getProperty("server.port"));
        return offerRepo.save(req);
    }

    public List<Offer> getOffers() {
        return offerRepo.findAll();
    }

    public Optional<Offer> getOfferByPromoCode(String code) {
        return offerRepo.findById(code);
    }

    public Offer editOfferByPromoCode(String code, Offer req) {
        req.setPromoCode(code);
        req.setOfferServicePort(env.getProperty("server.port"));
        return offerRepo.save(req);
    }

    public boolean deleteOfferByPromoCode(String code) {
        offerRepo.deleteById(code);
        return true;
    }
}
