package b13.team9.ms.implementation.meru.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import b13.team9.ms.implementation.meru.model.Promocode;

@Repository
public interface PromocodeRepository extends MongoRepository<Promocode, String> {

    @Query("{productId:'?0'}")
    Optional<Promocode> findproductById(String id);
}
