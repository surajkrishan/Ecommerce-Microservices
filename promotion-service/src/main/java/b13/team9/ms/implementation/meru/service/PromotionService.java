package b13.team9.ms.implementation.meru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b13.team9.ms.implementation.meru.model.Promotion;
import b13.team9.ms.implementation.meru.repository.PromotionRepository;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promoRepo;

    public List<Promotion> getPromotions() {
        return promoRepo.findAll();
    }

    public Optional<Promotion> getPromotionByPromoCode(String code) {
        return promoRepo.findById(code);
    }

    public Optional<Promotion> getPromotionByPromoCodeByProductId(String id) {
        return promoRepo.findproductById(id);
    }
}
