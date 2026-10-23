package com.example.TempleFestival.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.TempleFestival.exception.DuplicateResourceException;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class GlobalExceptionHandle {
    
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex,HttpServletRequest request){


       ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                                               ex.getMessage(),
                                               LocalDateTime.now(),
                                               request.getRequestURI());

      
       return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(error);
    }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,HttpServletRequest request){


        Map<String , String> errors = new HashMap<>();

        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();

        for(FieldError error : fieldErrors){

            String field = error.getField();

            String message = error.getDefaultMessage();

            errors.put(field,message);
        }

         ErrorResponse error = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),
                                               "Validation failed",
                                               LocalDateTime.now(),
                                               request.getRequestURI(),
                                               errors);

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error);

   }

   @ExceptionHandler(DuplicateResourceException.class)
   public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex,HttpServletRequest request){

         ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(),
                                                ex.getMessage(),
                                                LocalDateTime.now(),
                                                request.getRequestURI());
                                               

     return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(error);
            
         
   }                              
   
   @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex,HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(400,
                                              ex.getMessage(),
                                              LocalDateTime.now(),
                                             request.getRequestURI());

         return ResponseEntity
         .status(HttpStatus.BAD_REQUEST)
         .body(error);                                    
        
    }

    }

