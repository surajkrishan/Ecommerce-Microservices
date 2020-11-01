package com.meru.productservice.proxy;

import com.meru.productservice.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "offer-service")
@RibbonClient(name = "offer-service")
public interface OfferServiceProxy {

    @GetMapping("/getOffers")
    public List<Product> getOffers();
}
