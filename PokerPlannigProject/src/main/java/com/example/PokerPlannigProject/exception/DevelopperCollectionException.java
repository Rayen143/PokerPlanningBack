package com.example.PokerPlannigProject.exception;
/**
 * Rayen Benoun
 */
public class DevelopperCollectionException extends Exception{
    private static final long  serialVersionUID=1L;
    public DevelopperCollectionException(String message){super(message);}

    public static String NotFoundException(String id){return "Developper with "+id+" not found";}

    public static String DevelopperAlreadyExists(){return "Developper with given name already exists";}

}
