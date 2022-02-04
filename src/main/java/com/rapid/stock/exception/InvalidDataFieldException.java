package com.rapid.stock.exception;

public class InvalidDataFieldException extends RuntimeException{
    public InvalidDataFieldException(String message){
           super(message);
    }
}
