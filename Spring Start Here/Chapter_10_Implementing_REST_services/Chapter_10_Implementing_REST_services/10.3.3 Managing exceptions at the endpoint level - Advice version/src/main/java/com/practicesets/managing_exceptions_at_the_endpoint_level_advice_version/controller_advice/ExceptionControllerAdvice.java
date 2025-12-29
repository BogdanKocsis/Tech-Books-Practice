package com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.controller_advice;

import com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.exception.NotEnoughMoneyException;
import com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
