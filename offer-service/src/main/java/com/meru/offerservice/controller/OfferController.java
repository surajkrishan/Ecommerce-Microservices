package com.meru.offerservice.controller;

import java.util.List;
import java.util.Optional;

import com.meru.offerservice.model.Offer;
import com.meru.offerservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/addOffer")
	public Offer addOffer(@RequestBody Offer req) {
		return offerService.addOffer(req);
	}

	@GetMapping("/getOffers")
	public List<Offer> getOffers() {
		return offerService.getOffers();
	}

	@GetMapping("/getOfferByPromoCode/{code}")
	public Optional<Offer> getOfferByPromoCode(@PathVariable String code) {
		return offerService.getOfferByPromoCode(code);
	}

	@PutMapping("/editOfferByPromoCode/{code}")
	public Offer editOfferByPromoCode(@PathVariable String code, @RequestBody Offer req) {
		return offerService.editOfferByPromoCode(code, req);
	}

	@DeleteMapping("/deleteOfferByPromoCode/{code}")
	public boolean deleteOfferByPromoCode(@PathVariable String code) {
		return offerService.deleteOfferByPromoCode(code);
	}
}
