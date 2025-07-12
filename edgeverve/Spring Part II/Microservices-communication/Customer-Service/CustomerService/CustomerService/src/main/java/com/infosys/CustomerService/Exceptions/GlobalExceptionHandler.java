package com.infosys.CustomerService.Exceptions;

import com.infosys.CustomerService.Entitties.CustomerResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;


@RestControllerAdvice(annotations = RestController.class)

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

            // TODO Auto-generated method stub
            CustomerResponse customerResponse = new CustomerResponse(status.toString(),ex.getBindingResult().toString());
            // CustomerResponse customerResponse = new  CustomerResponse(status.toString(),ex.getMessage());
            return new ResponseEntity(customerResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<CustomerResponse> exceptionHandler(CustomerNotFoundException exception)
    {
        CustomerResponse response = new CustomerResponse("500",exception.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
