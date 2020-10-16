package com.meru.offerservice.controller;

import java.util.List;
import java.util.Optional;

import com.meru.offerservice.exception.CustomMessageException;
import com.meru.offerservice.model.Offer;
import com.meru.offerservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/addOffer")
	public Offer addOffer(@RequestBody Offer req) {
		try {
			return offerService.addOffer(req);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.CREATED,e.getMessage());
		}
	}

	@GetMapping("/getOffers")
	public List<Offer> getOffers() {
		try {
			return offerService.getOffers();
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@GetMapping("/getOfferByPromoCode/{code}")
	public Optional<Offer> getOfferByPromoCode(@PathVariable String code) {
		try {
			return offerService.getOfferByPromoCode(code);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@PutMapping("/editOfferByPromoCode/{code}")
	public Offer editOfferByPromoCode(@PathVariable String code, @RequestBody Offer req) {
		try {
			return offerService.editOfferByPromoCode(code, req);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@DeleteMapping("/deleteOfferByPromoCode/{code}")
	public boolean deleteOfferByPromoCode(@PathVariable String code) {
		try {
			return offerService.deleteOfferByPromoCode(code);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
}
