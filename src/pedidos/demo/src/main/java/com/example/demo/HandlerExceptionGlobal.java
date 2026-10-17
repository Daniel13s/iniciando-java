package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pedidos.demo.src.main.java.com.example.demo.PedidoNaoEncontradoException;

@RestControllerAdvice
public class HandlerExceptionGlobal {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarArgumentoInvalido(
            IllegalArgumentException exception) {

        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<String> tratarPedidoNaoEncontrado(
            PedidoNaoEncontradoException exception) {

        return ResponseEntity
                .notFound()
                .build();
    }
}