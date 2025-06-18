package com.fiap.dashboard.api.controller;

import com.fiap.dashboard.api.model.Equipamento;
import com.fiap.dashboard.api.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping("/registrar")
    public Equipamento registrar(@RequestBody Equipamento equipamento) {
        return equipamentoService.salvar(equipamento);
    }

    @GetMapping("/listar")
    public List<Equipamento> listarTodos() {
        return equipamentoService.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Equipamento equipamento = equipamentoService.buscarPorId(id);
        if (equipamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamento);
    }

    @DeleteMapping("/listar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        Equipamento equipamento = equipamentoService.buscarPorId(id);
        if (equipamento == null) {
            return ResponseEntity.status(404).body("Equipamento não encontrado.");
        }
        equipamentoService.deletarPorId(id);
        return ResponseEntity.ok("Equipamento deletado com sucesso.");
    }

    @PutMapping("/listar/{id}/status")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @RequestBody int novoStatus) {
        boolean atualizado = equipamentoService.atualizarStatus(id, novoStatus);
        if (!atualizado) {
            return ResponseEntity.status(404).body("Equipamento não encontrado.");
        }
        return ResponseEntity.ok("Status atualizado com sucesso.");
    }
}