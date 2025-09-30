package com.fiap.dashboard.api.controller;

import com.fiap.dashboard.api.dto.ProdutoRequest;
import com.fiap.dashboard.api.dto.ProdutoResponse;
import com.fiap.dashboard.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/registrar")
    public ProdutoResponse registrarProduto(@RequestBody ProdutoRequest dto) {
        return produtoService.salvarProduto(dto);
    }

    @GetMapping("/listar")
    public List<ProdutoResponse> listarProdutos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable String id) {
        ProdutoResponse produto = produtoService.buscarPorId(id);
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com ID " + id + " não encontrado.");
        }
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/listar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable String id) {
        ProdutoResponse produto = produtoService.buscarPorId(id);
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com ID " + id + " não encontrado.");
        }
        produtoService.deletarPorId(id);
        return ResponseEntity.ok("Produto removido com sucesso.");
    }

    @PutMapping("/listar/{id}/rota")
    public ResponseEntity<String> atualizarRota(@PathVariable String id, @RequestBody double novaRota) {
        boolean atualizado = produtoService.atualizarRota(id, novaRota);
        if (!atualizado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com ID " + id + " não encontrado.");
        }
        return ResponseEntity.ok("Rota atualizada com sucesso.");
    }
}
