package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.DevelopperCollectionException;
import com.example.PokerPlannigProject.model.Developper;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
/**
 * Rayen Benoun
 */
public interface IDevelopperService {

    void createDevelopper(Developper developper)throws ConstraintViolationException, DevelopperCollectionException;

    List<Developper>getAllDeveloppers();

    Developper getSingleDevelopper(String id)throws DevelopperCollectionException;

    void updateDevelopper(String id,Developper developper)throws DevelopperCollectionException;

    void deleteDevelopperById(String id) throws DevelopperCollectionException;
}
