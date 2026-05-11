package com.daniellevino.excption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(MusicNotFoundException.class)
    public ResponseEntity<Object> treatMusicNotFound(MusicNotFoundException e) {
        return ResponseEntity.status(404).body(Map.of(
        "error", "Not Found",
        "message", e.getMessage(),
        "status", 404
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.status(400).body(Map.of(
            "error", "Bad Request",
            "details", errors,
            "status", 400
        ));
    }
}
