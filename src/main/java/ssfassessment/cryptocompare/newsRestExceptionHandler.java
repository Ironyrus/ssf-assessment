package ssfassessment.cryptocompare;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class newsRestExceptionHandler {
    
    //Handles id not found exception (When getting news via postman)
    @ExceptionHandler
    public ResponseEntity<newsErrorResponse> handleException(newsNotFoundException e) {
        newsErrorResponse error = new newsErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage()); 
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //catch-all: handles all types of exceptions (When getting news via Postman)
    @ExceptionHandler
    public ResponseEntity<newsErrorResponse> handleException(Exception e) {
        newsErrorResponse error = new newsErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage()); 
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
