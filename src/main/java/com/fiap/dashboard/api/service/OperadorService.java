package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.dto.OperadorRequest;
import com.fiap.dashboard.api.dto.OperadorResponse;
import com.fiap.dashboard.api.model.Operador;
import com.fiap.dashboard.api.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepository operadorRepository;

    public OperadorResponse salvarOperador(OperadorRequest dto) {
        Operador operador = new Operador();
        operador.setEmail(dto.getEmail());
        operador.setSenha(dto.getSenha());

        Operador salvo = operadorRepository.save(operador);
        return toResponse(salvo);
    }

    public List<OperadorResponse> listarOperador() {
        return operadorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<OperadorResponse> buscarOperadorPorId(Long id) {
        return operadorRepository.findById(id)
                .map(this::toResponse);
    }

    public void deletarPorId(Long id) {
        operadorRepository.deleteById(id);
    }

    public boolean autenticar(String email, String senha) {
        return operadorRepository.findByEmailAndSenha(email, senha).isPresent();
    }

    private OperadorResponse toResponse(Operador operador) {
        return new OperadorResponse(
                operador.getId(),
                operador.getEmail()
        );
    }
}
