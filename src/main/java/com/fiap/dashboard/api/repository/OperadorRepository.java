package com.fiap.dashboard.api.repository;

import com.fiap.dashboard.api.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
    Optional<Operador> findByEmailAndSenha(String email, String senha);
    Optional<Operador> findByEmail(String email);
}
