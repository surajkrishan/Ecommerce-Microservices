package b13.team9.ms.implementation.meru.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import b13.team9.ms.implementation.meru.model.Promocode;
import b13.team9.ms.implementation.meru.service.PromocodeService;

@RestController
public class PromocodeController {

    @Autowired
    private PromocodeService offerService;

    @PostMapping("/addOffer")
    public Promocode addOffer(@RequestBody Promocode req) {
        return offerService.addOffer(req);
    }

    @GetMapping("/getAllOffers")
    public List<Promocode> getAlloffers() {
        return offerService.getAllOffer();
    }

    @GetMapping("/getOfferByPromoCode/{code}")
    public Optional<Promocode> getOfferByPromoCode(@PathVariable String code) {
        return offerService.getOfferByPromoCode(code);
    }

    @GetMapping("/getOfferByProductId/{code}")
    public Optional<Promocode> getOfferByProductId(@PathVariable String code) {
        return offerService.getOfferByProductId(code);
    }

    @PutMapping("/editOfferByPromoCode/{code}")
    public Promocode editofferById(@PathVariable String code, @RequestBody Promocode req) {
        return offerService.editOfferByPromoCode(code, req);
    }

    @DeleteMapping("/deleteOfferByPromoCode/{code}")
    public boolean deleteofferByPromoCode(@PathVariable String code) {
        return offerService.deleteOfferByPromoCode(code);
    }
}
