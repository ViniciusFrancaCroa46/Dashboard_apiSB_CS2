package com.fiap.dashboard.api.controller;

import com.fiap.dashboard.api.model.Operador;
import com.fiap.dashboard.api.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operadores")
public class OperadorController {
    @Autowired
    private OperadorService operadorService;

    @PostMapping("/registrar")
    public Operador registrarOperador(@RequestBody Operador operador) {
        return operadorService.salvarOperador(operador);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Operador operador) {
        boolean autenticado = operadorService.autenticar(operador.getEmail(), operador.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos.");
        }
    }
}
