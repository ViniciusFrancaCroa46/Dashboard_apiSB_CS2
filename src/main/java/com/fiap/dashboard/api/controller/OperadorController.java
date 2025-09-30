package com.fiap.dashboard.api.controller;

import com.fiap.dashboard.api.dto.OperadorRequest;
import com.fiap.dashboard.api.dto.OperadorResponse;
import com.fiap.dashboard.api.model.Operador;
import com.fiap.dashboard.api.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadores")
public class OperadorController {
    @Autowired
    private OperadorService operadorService;

    @PostMapping("/registrar")
    public OperadorResponse registrarOperador(@RequestBody OperadorRequest dto) {
        return operadorService.salvarOperador(dto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OperadorResponse>> listar() {
        return ResponseEntity.ok(operadorService.listarOperador());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<OperadorResponse> buscarPorId(@PathVariable Long id) {
        return operadorService.buscarOperadorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/listar/{id}")
    public ResponseEntity<Void> deletarOperador(@PathVariable Long id) {
        if (operadorService.buscarOperadorPorId(id).isPresent()) {
            operadorService.deletarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody OperadorRequest dto) {
        boolean autenticado = operadorService.autenticar(dto.getEmail(), dto.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos.");
        }
    }
}
