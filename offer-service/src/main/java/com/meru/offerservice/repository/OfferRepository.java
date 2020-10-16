package com.meru.offerservice.repository;

import com.meru.offerservice.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {

    @Query("{offerName:'?0'}")
    Offer findByOfferName(String offerName);
}
