package b13.team9.ms.implementation.meru.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import b13.team9.ms.implementation.meru.model.Promotion;

@Repository
public interface PromotionRepository extends MongoRepository<Promotion, String> {

    @Query("{productId:'?0'}")
    Optional<Promotion> findproductById(String id);
}
