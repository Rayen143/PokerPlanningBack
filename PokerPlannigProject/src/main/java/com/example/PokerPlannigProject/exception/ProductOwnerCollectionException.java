package com.example.PokerPlannigProject.exception;
/**
 * Rayen Benoun
 */
public class ProductOwnerCollectionException extends Exception{
    private static final long  serialVersionUID=1L;
    public ProductOwnerCollectionException(String message){super(message);}

    public static String NotFoundException(String id){return "ProductOwner with "+id+" not found";}

    public static String ProductOwnerAlreadyExists(){return "ProductOwner with given name already exists";}
}
