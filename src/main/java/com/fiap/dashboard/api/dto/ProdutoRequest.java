package com.fiap.dashboard.api.dto;

import java.util.Date;

public class ProdutoRequest {
    private String id;
    private String setor;
    private Date dataSaida;
    private String status;
    private Double rota;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRota() {
        return rota;
    }
    public void setRota(Double rota) {
        this.rota = rota;
    }
}
