package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.model.Operador;
import com.fiap.dashboard.api.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepository operadorRepository;

    public Operador salvarOperador(Operador operador) {
        return operadorRepository.save(operador);
    }

    public boolean autenticar(String email, String senha) {
        Optional<Operador> operador = operadorRepository.findByEmailAndSenha(email, senha);
        return operador.isPresent();
    }
}
