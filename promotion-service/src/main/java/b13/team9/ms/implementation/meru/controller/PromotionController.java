package b13.team9.ms.implementation.meru.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import b13.team9.ms.implementation.meru.model.Promotion;
import b13.team9.ms.implementation.meru.service.PromotionService;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promoService;

    @GetMapping("/getPromotions")
    public List<Promotion> getPromotions() {
        return promoService.getPromotions();
    }

    @GetMapping("/getPromotion/{code}")
    public Optional<Promotion> getPromotionByPromoCode(@PathVariable String code) {
        return promoService.getPromotionByPromoCode(code);
    }

    @GetMapping("/getPromotionByProductId/{id}")
    public Optional<Promotion> getPromotionByPromoCodeByProductId(@PathVariable String id) {
        return promoService.getPromotionByPromoCodeByProductId(id);
    }
}
