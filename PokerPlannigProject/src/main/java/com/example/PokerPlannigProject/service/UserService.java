package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.UserCollectionException;
import com.example.PokerPlannigProject.model.User;
import com.example.PokerPlannigProject.repository.IUserRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * Rayen Benoun
 */
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void createUser(User user) throws ConstraintViolationException, UserCollectionException {
        Optional<User> userOptional=userRepository.findUserBy(user.getName());
        if (userOptional.isPresent()){
            throw new UserCollectionException(UserCollectionException.UserAlreadyExists());
        }else {
            user.setCreatedAt(new Date(System.currentTimeMillis()));
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        if (users.size()>0){
            return users;
        }else {
            return new ArrayList<User>();
        }
    }

    @Override
    public User getSingleUser(String id) throws UserCollectionException {
        Optional<User>optionalUser=userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else {
            throw new UserCollectionException(UserCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void updateUser(String id, User user) throws UserCollectionException {
        Optional<User>optionalUser=userRepository.findById(id);
        if (optionalUser.isPresent()){
            User userUpdate=optionalUser.get();
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
            userRepository.save(userUpdate);
        }else {
            throw new UserCollectionException(UserCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void deleteUserById(String id) throws UserCollectionException {
        Optional<User>optionalUser=userRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new UserCollectionException(UserCollectionException.NotFoundException(id));
        }else {
            userRepository.deleteById(id);
        }
    }
}
