package com.planificador.klyro.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Map<String, Object>> crearRespuesta(
            HttpStatus estado,
            String mensaje,
            Object detalles) {

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("fecha", LocalDateTime.now());
        respuesta.put("status", estado.value());
        respuesta.put("error", estado.getReasonPhrase());
        respuesta.put("mensaje", mensaje);

        if (detalles != null) {
            respuesta.put("detalles", detalles);
        }

        return ResponseEntity.status(estado).body(respuesta);
    }

    // Error 400: Validaciones
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidaciones(
            MethodArgumentNotValidException ex) {

        Map<String, String> errores = new LinkedHashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        }

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                "Los datos enviados no son válidos",
                errores
        );
    }

    // Error 404: Tarea no encontrada
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(
            ResourceNotFoundException ex) {

        return crearRespuesta(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                null
        );
    }

    // Error 400: JSON incorrecto
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> manejarJsonIncorrecto(
            HttpMessageNotReadableException ex) {

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                "El JSON enviado es incorrecto o contiene datos inválidos",
                null
        );
    }

    // Error 400: Problemas de integridad de datos
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> manejarIntegridad(
            DataIntegrityViolationException ex) {

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                "No se pudo guardar la información por restricciones de la base de datos",
                null
        );
    }

    // Error 500: Errores inesperados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarErrorGeneral(
            Exception ex) {

        return crearRespuesta(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Ocurrió un error interno en el servidor",
                null
        );
    }
}
