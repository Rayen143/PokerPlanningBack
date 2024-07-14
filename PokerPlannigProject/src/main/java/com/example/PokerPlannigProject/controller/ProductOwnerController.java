package com.example.PokerPlannigProject.controller;

import com.example.PokerPlannigProject.exception.ProductOwnerCollectionException;
import com.example.PokerPlannigProject.model.ProductOwner;
import com.example.PokerPlannigProject.model.User;
import com.example.PokerPlannigProject.service.IProductOwnerService;
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
@RequestMapping("/productowner")
public class ProductOwnerController {

    @Autowired
    private IProductOwnerService productOwnerService;

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllProductOwner(){
        List<ProductOwner> productOwners=productOwnerService.getAllProductOwners();
        return new ResponseEntity<>(productOwners,productOwners.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?>createProductOwner(@RequestBody ProductOwner productOwner) {
        try {
            productOwnerService.createProductOwner(productOwner);
            return new ResponseEntity<ProductOwner>(productOwner, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (ProductOwnerCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?>getSingleProductOwner(@PathVariable("id")String id){
        try {
            return new ResponseEntity<>(productOwnerService.getSingleProductOwner(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?>updateById(@PathVariable("id")String id,@RequestBody ProductOwner productOwner){
        try {
            productOwnerService.updateProductOwner(id,productOwner);
            return new ResponseEntity<>("update product owner with id ="+id,HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (ProductOwnerCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable("id")String id){
        try {
            productOwnerService.deleteProductOwnerById(id);
            return new ResponseEntity<>("succefully deleted with id "+ id,HttpStatus.OK);
        }catch(ProductOwnerCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
