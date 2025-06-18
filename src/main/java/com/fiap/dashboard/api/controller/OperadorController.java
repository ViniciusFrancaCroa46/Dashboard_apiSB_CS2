package com.fiap.dashboard.api.controller;

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

    public OperadorController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }


    @PostMapping("/registrar")
    public Operador registrarOperador(@RequestBody Operador operador) {
        return operadorService.salvarOperador(operador);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Operador>> listar() {
        List<Operador> operador = operadorService.listarOperador();
        return ResponseEntity.ok(operador);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Operador> buscarPorId(@PathVariable Long id) {
        return operadorService.buscarOperadorPorId(id)
                .map (ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("listar/{id}")
    public ResponseEntity<Void> deletarOperador(@PathVariable Long id) {
        if(operadorService.buscarOperadorPorId(id).isPresent()){
            operadorService.deletarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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
