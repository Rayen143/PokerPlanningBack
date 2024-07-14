package com.example.PokerPlannigProject.repository;

import com.example.PokerPlannigProject.model.Developper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
/**
 * Rayen Benoun
 */
public interface IDevelopperRepository extends MongoRepository<Developper,String> {

    @Query("{'developper': ?0}")
    Optional<Developper> findDevelopperBy(String developper);
}
