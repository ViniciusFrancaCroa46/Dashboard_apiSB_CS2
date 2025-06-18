package com.fiap.dashboard.api.repository;

import com.fiap.dashboard.api.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}