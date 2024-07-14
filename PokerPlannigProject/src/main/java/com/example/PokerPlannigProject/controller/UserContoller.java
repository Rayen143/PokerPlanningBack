package com.example.PokerPlannigProject.controller;

import com.example.PokerPlannigProject.exception.UserCollectionException;
import com.example.PokerPlannigProject.model.User;
import com.example.PokerPlannigProject.service.IDevelopperService;
import com.example.PokerPlannigProject.service.IUserService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Rayen Benoun
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserContoller {
    @Autowired
    private IUserService userService;
    @GetMapping("/getAll")
    public ResponseEntity<?>getAllTodos(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,users.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create")
    public ResponseEntity<?>createUser(@RequestBody User user){
        try {
            userService.createUser(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }catch(UserCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?>getSingleUser(@PathVariable("id")String id){
        try {
            return new ResponseEntity<>(userService.getSingleUser(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?>updateById(@PathVariable("id")String id,@RequestBody User user){
        try {
            userService.updateUser(id,user);
            return new ResponseEntity<>("update user with id ="+id,HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (UserCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable("id")String id){
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>("succefully deleted with id"+id,HttpStatus.OK);
        }catch (UserCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
