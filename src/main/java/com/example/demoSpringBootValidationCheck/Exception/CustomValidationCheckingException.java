package com.example.demoSpringBootValidationCheck.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestControllerAdvice
public class CustomValidationCheckingException extends ResponseEntityExceptionHandler {

//    //** This below method is for validation checking and give proper error's message of each field.
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
//                                                                  HttpStatus status, WebRequest request) {
//        Map<String,String> errors=new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error)->{
//            String fieldName= ((FieldError)error).getField();
//            String message=error.getDefaultMessage();
//            errors.put(fieldName,message);
//        });
//        return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
//    }


    //**This method work is same as above method.
    //** This below method is for validation checking and give proper error's message of each field.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String,Object> errors=new LinkedHashMap<>();
        errors.put("Timestamp ",new Date());
        errors.put("Status ",status.value());
        List<ObjectError> fieldErrors= ex.getBindingResult().getAllErrors();
        List<String> listError=new ArrayList<>();
        for (ObjectError fieldError : fieldErrors){
            String errorMessage=fieldError.getDefaultMessage();
            listError.add(errorMessage);
        }
         errors.put("Errors ",listError);
        return new ResponseEntity<Object>(errors,headers,status);
    }


    //** This below method is for RequestMethodNotSupported checking and give proper error message.
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        Map<String,Object> errors=new LinkedHashMap<>();
        errors.put("Timestamp ",new Date());
        //errors.put("Status ",HttpStatus.METHOD_NOT_ALLOWED);
        errors.put("Status ",status.value());
        errors.put("Message ","Request Method Type is not properly choose, please change the Proper Http method type.");
        errors.put("Supported Method is ",ex.getSupportedHttpMethods());
        //return new ResponseEntity<Object>(errors,status);
        return new ResponseEntity<Object>(errors,HttpStatus.METHOD_NOT_ALLOWED);

        //** Below line is also work when above lines are not allowed here
        //return new ResponseEntity<Object>("Request Method is not properly choose.",HttpStatus.METHOD_NOT_ALLOWED);
    }


//    @ExceptionHandler(UserException.class)
//    public ResponseEntity<Object> CustomBusinessException(UserException ex){
//        Map<String,Object> map=new HashMap<>();
//        map.put("Status ", HttpStatus.NO_CONTENT);
//        map.put("Message ","Employee Data Base is Empty.");
//        return new ResponseEntity<Object>(map,HttpStatus.NO_CONTENT);
//    }


}
