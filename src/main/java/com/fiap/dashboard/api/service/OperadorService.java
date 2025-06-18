package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.model.Operador;
import com.fiap.dashboard.api.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepository operadorRepository;

    public OperadorService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    public Operador salvarOperador(Operador operador) {
        return operadorRepository.save(operador);
    }

    public List<Operador> listarOperador() {
        return operadorRepository.findAll();
    }

    public Optional <Operador> buscarOperadorPorId(Long id) {
        return operadorRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        operadorRepository.deleteById(id);
    }

    public boolean autenticar(String email, String senha) {
        Optional<Operador> operador = operadorRepository.findByEmailAndSenha(email, senha);
        return operador.isPresent();
    }
}
