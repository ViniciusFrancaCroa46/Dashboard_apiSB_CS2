package com.fiap.dashboard.api.dto;

public class EquipamentoResponse {
    private Long id;
    private String setor;
    private int status;
    private String tipo;
    private long consumo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
