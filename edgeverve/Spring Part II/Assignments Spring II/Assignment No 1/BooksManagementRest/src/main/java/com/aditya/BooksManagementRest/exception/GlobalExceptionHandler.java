package com.aditya.BooksManagementRest.exception;

import com.aditya.BooksManagementRest.model.BooksResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        BooksResponse response = new BooksResponse();
//        response.setStatusCode(400);
//        response.setStatusMsg("Invalid Input: " + ex.getBindingResult().getFieldError().getDefaultMessage());
        response.setStatusMsg(ex.getBindingResult().toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<BooksResponse> exceptionHandler(BooksException booksException) {
        BooksResponse response = new BooksResponse();
        response.setStatusCode(500);
        response.setStatusMsg("Book Not Found");
        return new ResponseEntity<BooksResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
