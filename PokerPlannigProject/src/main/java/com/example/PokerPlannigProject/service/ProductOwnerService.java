package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.ProductOwnerCollectionException;
import com.example.PokerPlannigProject.model.ProductOwner;
import com.example.PokerPlannigProject.repository.IProductOwnerRepository;
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
public class ProductOwnerService implements IProductOwnerService{
    @Autowired
    private IProductOwnerRepository productOwnerRepository;
    @Override
    public void createProductOwner(ProductOwner productOwner) throws ConstraintViolationException, ProductOwnerCollectionException {
        Optional<ProductOwner> productOwnerOptional=productOwnerRepository.findProductOwnerBy(productOwner.getName());
        if (productOwnerOptional.isPresent()){
            throw new ProductOwnerCollectionException(ProductOwnerCollectionException.ProductOwnerAlreadyExists());
        }else {
            productOwner.setCreatedAt(new Date(System.currentTimeMillis()));
            productOwnerRepository.save(productOwner);
        }
    }

    @Override
    public List<ProductOwner> getAllProductOwners() {
        List<ProductOwner>productOwners=productOwnerRepository.findAll();
        if (productOwners.size()>0){
            return productOwners;
        }else {
            return new ArrayList<ProductOwner>();
        }
    }

    @Override
    public ProductOwner getSingleProductOwner(String id) throws ProductOwnerCollectionException {
        Optional<ProductOwner>optionalProductOwner=productOwnerRepository.findById(id);
        if (optionalProductOwner.isPresent()){
            return optionalProductOwner.get();
        }else {
            throw new ProductOwnerCollectionException(ProductOwnerCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void updateProductOwner(String id, ProductOwner productOwner) throws ProductOwnerCollectionException {
        Optional<ProductOwner>optionalProductOwner=productOwnerRepository.findById(id);
        if (optionalProductOwner.isPresent()){
            ProductOwner productOwnerUpdate=optionalProductOwner.get();
            productOwnerUpdate.setName(productOwner.getName());
            productOwnerUpdate.setEmail(productOwner.getEmail());
            productOwnerUpdate.setPassword(productOwner.getPassword());
            productOwnerUpdate.setPost(productOwner.getPost());
            productOwnerUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
            productOwnerRepository.save(productOwnerUpdate);
        }else {
            throw new ProductOwnerCollectionException(ProductOwnerCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void deleteProductOwnerById(String id) throws ProductOwnerCollectionException {
        Optional<ProductOwner>optionalProductOwner=productOwnerRepository.findById(id);
        if (!optionalProductOwner.isPresent()){
            throw new ProductOwnerCollectionException(ProductOwnerCollectionException.NotFoundException(id));
        }else {
            productOwnerRepository.deleteById(id);
        }
    }
}
