package com.example.crud.exception;

public class OutOfStockException extends Exception {

    public OutOfStockException(){
        super();
    }

    public OutOfStockException(String s){
        super(s);
    }

}
