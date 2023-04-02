package com.example.WalletProject.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;


@RestControllerAdvice
public class ExceptionController
{
@ExceptionHandler(SQLException.class)
public String SQLExceptionHandler(SQLException e) {
    String log = "ошибка базы данных,возможно вы ввели повторные " +
            "или некоректные значения либо запросили не существующие";
    return log;
}
//    @ExceptionHandler(EntityNotFoundException.class)
//    public String EntityNotFoundExceptionHandler(EntityNotFoundException e) {
//        String log = "значение не найдено";
//        return log;
//    }
}
