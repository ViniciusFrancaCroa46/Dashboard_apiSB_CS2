package com.fiap.dashboard.api.repository;

import com.fiap.dashboard.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}