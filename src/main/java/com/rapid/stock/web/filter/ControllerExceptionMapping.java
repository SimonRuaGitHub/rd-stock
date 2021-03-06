package com.rapid.stock.web.filter;

import com.rapid.stock.dto.RestExceptionResult;
import com.rapid.stock.exception.NotFoundException;
import com.rapid.stock.exception.SaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionMapping {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestExceptionResult> handleEntityNotFound(NotFoundException ex){
           ex.printStackTrace();
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestExceptionResult(ex.getMessage()));
    }

    @ExceptionHandler(SaveException.class)
    public ResponseEntity<RestExceptionResult> handleUnableToSaveEntity(SaveException ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestExceptionResult(ex.getMessage()));
    }
}
