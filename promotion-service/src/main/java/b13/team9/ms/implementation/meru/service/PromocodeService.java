package b13.team9.ms.implementation.meru.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import b13.team9.ms.implementation.meru.model.Promocode;
import b13.team9.ms.implementation.meru.model.Promotion;
import b13.team9.ms.implementation.meru.repository.PromocodeRepository;
import b13.team9.ms.implementation.meru.repository.PromotionRepository;

@Service
public class PromocodeService {

    @Autowired
    private PromocodeRepository offerRepo;
    @Autowired
    private PromotionRepository promoRepo;
    @Autowired
    Environment env;

    public Promocode addOffer(Promocode req) {
        long randomId = new Date().getTime();
        String promoCode = Long.toString(randomId);
        req.setPromoCode("PROMO" + promoCode.substring(8));
        Promotion temp = new Promotion(req.getPromoCode(), "", env.getProperty("server.port"));
        promoRepo.save(temp);
        return offerRepo.save(req);
    }

    public List<Promocode> getAllOffer() {
        return offerRepo.findAll();
    }

    public Optional<Promocode> getOfferByPromoCode(String code) {
        return offerRepo.findById(code);
    }

    public Optional<Promocode> getOfferByProductId(String code) {
        return offerRepo.findproductById(code);
    }

    public Promocode editOfferByPromoCode(String code, Promocode req) {
        req.setPromoCode(code);
        return offerRepo.save(req);
    }

    public boolean deleteOfferByPromoCode(String code) {
        offerRepo.deleteById(code);
        return true;
    }
}
