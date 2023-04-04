package com.example.WalletProject.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Objects;


@RestControllerAdvice
public class ExceptionController {
//изменила метод, чтоб возвращал response-entity со статусом и сообщением
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> SQLExceptionHandler(SQLException e) {
        String log = "ошибка базы данных,возможно вы ввели повторные " +
                "или некоректные значения либо запросили не существующие";
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(log));
    }

    //    @ExceptionHandler(EntityNotFoundException.class)
//    public String EntityNotFoundExceptionHandler(EntityNotFoundException e) {
//        String log = "значение не найдено";
//        return log;
//    }

    //этот хэндлер ловит ошибки валидации
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(Objects.requireNonNull(e.getFieldError()).getDefaultMessage()));
    }
}
