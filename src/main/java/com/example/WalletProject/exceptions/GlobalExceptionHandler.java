package com.example.WalletProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(ClientNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(AccountNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(CurrencyNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(DocumentNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(UserNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(CountryNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<MyResponce> ExceptionHandler(TransactionNotFoundException exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity <MyResponce> ExceptionHandler(Exception exception) {
        MyResponce r=new MyResponce();
        r.setInfo(exception.getMessage());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyResponce> ExceptionHandler(MethodArgumentNotValidException e){
        StringBuilder errorMsg = new StringBuilder();
        List<FieldError> errors = e.getFieldErrors();
        for (FieldError error : errors) {
            errorMsg.append(error.getDefaultMessage()).
                    append(";");
        }
        MyResponce r=new MyResponce();
        r.setInfo(errorMsg.toString());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);

    }

}
