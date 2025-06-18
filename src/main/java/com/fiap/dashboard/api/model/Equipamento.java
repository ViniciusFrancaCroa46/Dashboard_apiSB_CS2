package com.fiap.dashboard.api.model;

import jakarta.persistence.*;

@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String setor; // "A" ou "B"

    @Column(nullable = false)
    private int status = 0; // 0 = desligado, valor padrão

    @Column(nullable = false)
    private String tipo; // "esteira" ou "AGV"

    @Column(nullable = false)
    private long consumo = 0; // Kw/h

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getConsumo() {
        return consumo;
    }

    public void setConsumo(long consumo) {
        this.consumo = consumo;
    }
}
