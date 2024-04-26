package com.project.project.controller;

import com.project.project.responHandler.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {// Exception untuk menangkap JSON parse erorr (misalnya : title tidak adaout of bound dari masukan data integer (sudah dicoba dengan Integer.MAX_Value masih belum bisa ditangkap))
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        CustomResponse response = new CustomResponse();
        response.setStatus("failed");
        response.setMessage("Format not correct or Data out of Bound");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        CustomResponse response = new CustomResponse();
        response.setStatus("failed");
        response.setMessage("Anda tidak berhak masuk, harap login terlebih dahulu, "+ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}


