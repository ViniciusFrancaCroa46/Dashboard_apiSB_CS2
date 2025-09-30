package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.dto.EquipamentoRequest;
import com.fiap.dashboard.api.dto.EquipamentoResponse;
import com.fiap.dashboard.api.model.Equipamento;
import com.fiap.dashboard.api.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    // Salvar equipamento
    public EquipamentoResponse salvar(EquipamentoRequest dto) {
        Equipamento equipamento = new Equipamento();
        equipamento.setSetor(dto.getSetor());
        equipamento.setTipo(dto.getTipo());
        equipamento.setStatus(dto.getStatus()); // opcional, ou default 0
        equipamento.setConsumo(dto.getConsumo());

        Equipamento salvo = equipamentoRepository.save(equipamento);
        return toResponse(salvo);
    }

    // Listar todos os equipamentos
    public List<EquipamentoResponse> listarTodos() {
        return equipamentoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public EquipamentoResponse buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    // Deletar por ID
    public void deletarPorId(Long id) {
        equipamentoRepository.deleteById(id);
    }

    // Atualizar status
    public boolean atualizarStatus(Long id, int novoStatus) {
        Equipamento equipamento = equipamentoRepository.findById(id).orElse(null);
        if (equipamento == null) {
            return false;
        }
        equipamento.setStatus(novoStatus);
        equipamentoRepository.save(equipamento);
        return true;
    }

    // Conversor de Entity para Response DTO
    private EquipamentoResponse toResponse(Equipamento equipamento) {
        EquipamentoResponse response = new EquipamentoResponse();
        response.setId(equipamento.getId());
        response.setSetor(equipamento.getSetor());
        response.setTipo(equipamento.getTipo());
        response.setStatus(equipamento.getStatus());
        response.setConsumo(equipamento.getConsumo());
        return response;
    }
}
