package com.fiap.dashboard.api.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResponse {
    private String id;
    private String setor;
    private Date dataSaida;
    private String status;
    private double rota;

    public ProdutoResponse() {}

    public ProdutoResponse(String id, String setor, Date dataSaida, String status, double rota) {
        this.id = id;
        this.setor = setor;
        this.dataSaida = dataSaida;
        this.status = status;
        this.rota = rota;
    }

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

    public double getRota() {
        return rota;
    }
    public void setRota(double rota) {
        this.rota = rota;
    }

    //Método auxiliar formatado
    @JsonProperty("dataSaidaFormatada")
    public String getDataSaidaFormatada() {
        if (dataSaida == null) return null;
        return new SimpleDateFormat("dd/MM/yyyy").format(dataSaida);
    }
}
