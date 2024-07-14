package com.example.PokerPlannigProject.repository;

import com.example.PokerPlannigProject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
/**
 * Rayen Benoun
 */
public interface IUserRepository extends MongoRepository<User,String> {
    @Query("{'user': ?0}")
    Optional<User> findUserBy(String user);
}
