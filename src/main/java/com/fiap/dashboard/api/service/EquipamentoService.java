package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.model.Equipamento;
import com.fiap.dashboard.api.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento salvar(Equipamento equipamento) {
        // Garante status 0 ao criar
        equipamento.setStatus(0);
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id).orElse(null);
    }

    public void deletarPorId(Long id) {
        equipamentoRepository.deleteById(id);
    }

    public boolean atualizarStatus(Long id, int novoStatus) {
        Equipamento equipamento = buscarPorId(id);
        if (equipamento == null) {
            return false;
        }
        equipamento.setStatus(novoStatus);
        equipamentoRepository.save(equipamento);
        return true;
    }
}
