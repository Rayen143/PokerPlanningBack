package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.UserCollectionException;
import com.example.PokerPlannigProject.model.User;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
/**
 * Rayen Benoun
 */
public interface IUserService {

    void createUser(User user) throws ConstraintViolationException, UserCollectionException;

    List<User> getAllUsers();

    User getSingleUser(String id)throws UserCollectionException;

    void updateUser(String id,User user)throws UserCollectionException;

    void deleteUserById(String id)throws UserCollectionException;

}
