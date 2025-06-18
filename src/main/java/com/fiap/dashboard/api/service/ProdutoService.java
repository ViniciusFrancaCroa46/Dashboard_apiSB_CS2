package com.fiap.dashboard.api.service;

import com.fiap.dashboard.api.model.Produto;
import com.fiap.dashboard.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        double r = produto.getRota();

        if (r >= 1 && r <= 3.5) {
            produto.setStatus("em movimento");
        } else if (r == 4) {
            produto.setStatus("entregue");
        }

        return produtoRepository.save(produto);
    }


    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletarPorId(String id) {
        produtoRepository.deleteById(id);
    }

    public boolean atualizarRota(String id, double novaRota) {
        Produto produto = buscarPorId(id);

        if (produto == null) {
            return false;
        }
        produto.setRota(novaRota);

        // Atualiza o status baseado na nova rota
        if (novaRota >= 1 && novaRota <= 3.5) {
            produto.setStatus("em movimento");
        } else if (novaRota == 4.0) {
            produto.setStatus("entregue");
        }

        salvarProduto(produto);
        return true;
    }
}
