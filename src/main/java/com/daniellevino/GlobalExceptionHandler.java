package com.daniellevino;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
}
