package com.example.PokerPlannigProject.controller;

import com.example.PokerPlannigProject.exception.DevelopperCollectionException;
import com.example.PokerPlannigProject.model.Developper;
import com.example.PokerPlannigProject.service.IDevelopperService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Rayen Benoun
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/developper")
public class DevelopperController {

    @Autowired
    private IDevelopperService developperService;

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllDevelopper(){
        List<Developper> developpers=developperService.getAllDeveloppers();
        return new ResponseEntity<>(developpers,developpers.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create")
    public ResponseEntity<?>createDevelopper(@RequestBody Developper developper) {
        try {
            developperService.createDevelopper(developper);
            return new ResponseEntity<Developper>(developper, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (DevelopperCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?>getSingleDevelopper(@PathVariable("id")String id){
        try {
            return new ResponseEntity<>(developperService.getSingleDevelopper(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?>updateDevelopper(@PathVariable("id")String id,@RequestBody Developper developper){
        try {
            developperService.updateDevelopper(id,developper);
            return new ResponseEntity<>("update developper with id ="+id,HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (DevelopperCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable("id")String id){
        try {
            developperService.deleteDevelopperById(id);
            return new ResponseEntity<>("succefully deleted with id "+id,HttpStatus.OK);
        }catch (DevelopperCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
