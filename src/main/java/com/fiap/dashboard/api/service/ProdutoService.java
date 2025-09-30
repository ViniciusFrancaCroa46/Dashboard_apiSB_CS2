package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.dto.ProdutoRequest;
import com.fiap.dashboard.api.dto.ProdutoResponse;
import com.fiap.dashboard.api.model.Produto;
import com.fiap.dashboard.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse salvarProduto(ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setSetor(dto.getSetor());
        produto.setDataSaida(dto.getDataSaida());
        produto.setStatus(dto.getStatus());
        produto.setRota(dto.getRota());

        // regra do status
        double r = produto.getRota();
        if (r >= 1 && r <= 3.5) {
            produto.setStatus("em movimento");
        } else if (r == 4) {
            produto.setStatus("entregue");
        }

        Produto salvo = produtoRepository.save(produto);
        return toResponse(salvo);
    }

    public List<ProdutoResponse> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse buscarPorId(String id) {
        return produtoRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    public void deletarPorId(String id) {
        produtoRepository.deleteById(id);
    }

    public boolean atualizarRota(String id, double novaRota) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null) {
            return false;
        }

        produto.setRota(novaRota);
        if (novaRota >= 1 && novaRota <= 3.5) {
            produto.setStatus("em movimento");
        } else if (novaRota == 4.0) {
            produto.setStatus("entregue");
        }

        produtoRepository.save(produto);
        return true;
    }

    private ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getSetor(),
                produto.getDataSaida(),
                produto.getStatus(),
                produto.getRota()
        );
    }
}
