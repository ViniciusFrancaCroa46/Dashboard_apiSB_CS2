package com.fiap.dashboard.api.controller;

import com.fiap.dashboard.api.dto.EquipamentoRequest;
import com.fiap.dashboard.api.dto.EquipamentoResponse;
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

    // Criar novo equipamento
    @PostMapping
    public ResponseEntity<EquipamentoResponse> registrar(@RequestBody EquipamentoRequest dto) {
        EquipamentoResponse response = equipamentoService.salvar(dto);
        return ResponseEntity.ok(response);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> listarTodos() {
        List<EquipamentoResponse> equipamentos = equipamentoService.listarTodos();
        return ResponseEntity.ok(equipamentos);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponse> buscarPorId(@PathVariable Long id) {
        EquipamentoResponse equipamento = equipamentoService.buscarPorId(id);
        if (equipamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamento);
    }

    // Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        EquipamentoResponse equipamento = equipamentoService.buscarPorId(id);
        if (equipamento == null) {
            return ResponseEntity.status(404).body("Equipamento não encontrado.");
        }
        equipamentoService.deletarPorId(id);
        return ResponseEntity.ok("Equipamento deletado com sucesso.");
    }

    // Atualizar status
    @PatchMapping("/{id}/status")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @RequestBody EquipamentoRequest request) {
        boolean atualizado = equipamentoService.atualizarStatus(id, request.getStatus());
        if (!atualizado) {
            return ResponseEntity.status(404).body("Equipamento não encontrado.");
        }
        return ResponseEntity.ok("Status atualizado com sucesso.");
    }
}
