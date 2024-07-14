package com.example.PokerPlannigProject.service;

import com.example.PokerPlannigProject.exception.DevelopperCollectionException;
import com.example.PokerPlannigProject.model.Developper;
import com.example.PokerPlannigProject.repository.IDevelopperRepository;
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
public class DevelopperService implements IDevelopperService{
@Autowired
    private IDevelopperRepository developperRepository;
    @Override
    public void createDevelopper(Developper developper) throws ConstraintViolationException, DevelopperCollectionException {
        Optional<Developper>developperOptional=developperRepository.findDevelopperBy(developper.getName());
        if (developperOptional.isPresent()){
            throw new DevelopperCollectionException(DevelopperCollectionException.DevelopperAlreadyExists());
        }else {
            developper.setCreatedAt(new Date(System.currentTimeMillis()));
            developperRepository.save(developper);
        }
    }

    @Override
    public List<Developper> getAllDeveloppers() {
        List<Developper>developpers=developperRepository.findAll();
        if (developpers.size()>0){
            return developpers;
        }else{
            return new ArrayList<Developper>();
        }
    }

    @Override
    public Developper getSingleDevelopper(String id) throws DevelopperCollectionException {
        Optional<Developper>optionalDevelopper=developperRepository.findById(id);
        if (optionalDevelopper.isPresent()){
            return optionalDevelopper.get();
        }else {
            throw new DevelopperCollectionException(DevelopperCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void updateDevelopper(String id, Developper developper) throws DevelopperCollectionException {
        Optional<Developper> developperOptional=developperRepository.findById(id);
        if (developperOptional.isPresent()){
            Developper developperUpdate=developperOptional.get();
            developperUpdate.setName(developper.getName());
            developperUpdate.setEmail(developper.getEmail());
            developperUpdate.setPassword(developper.getPassword());
            developperUpdate.setPost(developper.getPost());
            developperUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
            developperRepository.save(developperUpdate);

        }else{
            throw new DevelopperCollectionException(DevelopperCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void deleteDevelopperById(String id) throws DevelopperCollectionException {
        Optional<Developper>optionalDevelopper=developperRepository.findById(id);
        if (!optionalDevelopper.isPresent()){
            throw new DevelopperCollectionException(DevelopperCollectionException.NotFoundException(id));
        }else {
            developperRepository.deleteById(id);
        }
    }
}
