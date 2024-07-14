package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.ProductOwnerCollectionException;
import com.example.PokerPlannigProject.model.ProductOwner;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
/**
 * Rayen Benoun
 */
public interface IProductOwnerService {

    void createProductOwner(ProductOwner productOwner)throws ConstraintViolationException, ProductOwnerCollectionException;

    List<ProductOwner> getAllProductOwners();

    ProductOwner getSingleProductOwner(String id)throws ProductOwnerCollectionException;

    void updateProductOwner(String id,ProductOwner productOwner)throws ProductOwnerCollectionException;

    void deleteProductOwnerById(String id)throws ProductOwnerCollectionException;
}
