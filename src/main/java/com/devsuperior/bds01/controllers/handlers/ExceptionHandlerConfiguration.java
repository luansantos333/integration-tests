package com.devsuperior.bds01.controllers.handlers;

import com.devsuperior.bds01.dto.CustomError;
import com.devsuperior.bds01.services.exceptions.EmptyTableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler (EmptyTableException.class)
    public ResponseEntity<CustomError> emptyTableException (EmptyTableException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NO_CONTENT;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status.value()).body(err);

    }



}
