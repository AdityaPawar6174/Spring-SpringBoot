package com.infosys.demoPostgreRest.Exception;


import com.infosys.demoPostgreRest.model.CourseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CourseResponse> exceptionHandler(CourseException courseException){
        CourseResponse response = new CourseResponse();
        response.setStatusCode(500);
        response.setStatusMsg("Course Not Found");
        return new ResponseEntity<CourseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException){
//        CourseResponse response = new CourseResponse();
//        response.setStatusMsg(ex.getMessage());
//
//    }
}
