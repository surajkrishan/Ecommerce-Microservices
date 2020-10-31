package com.meru.productservice.proxy;

import com.meru.productservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "offer-service",url = "localhost:8080")
public interface OfferServiceProxy {

    @GetMapping("/getOffers")
    public List<Product> getOffers();
}
