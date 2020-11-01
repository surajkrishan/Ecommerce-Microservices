package com.meru.productservice.proxy;

import com.meru.productservice.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "offer-service")
public interface OfferServiceProxy {

    @GetMapping("/offer-service/getOffers")
    public List<Product> getOffers();
}
