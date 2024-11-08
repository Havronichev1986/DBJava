package org.example.exception;

import com.fasterxml.jackson.core.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j

public class BaseExceptionHandier extends ResponseEntityExceptionHandler {
    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handlerException(Exception ex){
        log.error("Произошла ошибка: {}" , ex.getMessage());
        return "Произощла ошибка: " + ex.getMessage();
    }
    @Override
    protected ResponseEntity<Object> hendleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){
        log.error("Ошибка с типом: {}",ex);
        return super.handleExceptionInternal(ex,body,headers,status,request);
    }
}
