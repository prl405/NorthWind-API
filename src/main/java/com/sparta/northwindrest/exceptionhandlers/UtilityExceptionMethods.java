package com.sparta.northwindrest.exceptionhandlers;

import java.util.List;

public class UtilityExceptionMethods {

    public static void checkUpperBound(Integer integer, Integer upperBound) throws EntityNotFoundException{
        if(integer > upperBound || integer < 0){
            throw new EntityNotFoundException("Out Of Bounds exception.");
        }
    }

    public static void checkBounds(Integer integer, Integer lowerBound, Integer upperBound) throws EntityNotFoundException{
        if(integer > upperBound || integer < lowerBound){
            throw new EntityNotFoundException("Out Of Bounds exception.");
        }
    }
}
