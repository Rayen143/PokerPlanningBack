package com.example.PokerPlannigProject.repository;

import com.example.PokerPlannigProject.model.ProductOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
/**
 * Rayen Benoun
 */
public interface IProductOwnerRepository extends MongoRepository<ProductOwner,String> {

    @Query("{'productowner': ?0}")
    Optional<ProductOwner> findProductOwnerBy(String productowner);
}
