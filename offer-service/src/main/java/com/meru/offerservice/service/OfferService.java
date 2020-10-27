package com.meru.offerservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.meru.offerservice.exception.CustomMessageException;
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

    public Offer addOffer(Offer req) throws CustomMessageException {
        Offer existingOffer = offerRepo.findByOfferName(req.getOfferName());
        if (existingOffer != null) {
            throw new CustomMessageException("Offer already exists in DB");
        }
        long randomId = new Date().getTime();
        String promoCode = Long.toString(randomId);
        req.setPromoCode("PROMO" + promoCode.substring(8));
        req.setOfferServicePort(env.getProperty("server.port"));
        return offerRepo.save(req);
    }

    public List<Offer> getOffers() throws CustomMessageException {
        List<Offer> optionalOffer = offerRepo.findAll();
        if (optionalOffer.isEmpty()) {
            throw new CustomMessageException("Offer Not Found in DB");
        }
        return offerRepo.findAll();
    }

    public Optional<Offer> getOfferByPromoCode(String code) throws CustomMessageException {
        Optional<Offer> optionalOffer = offerRepo.findById(code);
        if (!optionalOffer.isPresent()) {
            throw new CustomMessageException("Offer Not Found in DB");
        }
        return offerRepo.findById(code);
    }

    public Offer editOfferByPromoCode(String code, Offer req) throws CustomMessageException {
        Optional<Offer> optionalOffer = offerRepo.findById(code);
        if (!optionalOffer.isPresent()) {
            throw new CustomMessageException("Offer Not Found in DB");
        }
        req.setPromoCode(code);
        req.setOfferServicePort(env.getProperty("server.port"));
        return offerRepo.save(req);
    }

    public boolean deleteOfferByPromoCode(String code) throws CustomMessageException {
        Optional<Offer> optionalOffer = offerRepo.findById(code);
        if (!optionalOffer.isPresent()) {
            throw new CustomMessageException("Offer Not Found in DB");
        }
        offerRepo.deleteById(code);
        return true;
    }
}
