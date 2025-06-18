package com.fiap.dashboard.api.model;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name="Produto")
public class Produto {
    @Id
    private String id;

    @Column(nullable = false)
    private String setor;  // "A" ou "B"

    @Temporal(TemporalType.DATE)
    private Date dataSaida;  // Somente dia/mês/ano

    @Column(nullable = false)
    private String status;  // "entregue", "em movimento", "em estoque"

    @Column(nullable = false)
    private double rota;  // 0, 1, 1.5, 2, 2.5, 3, 3.5, 4

    @PrePersist
    public void gerarIdAutomatico() {
        if (this.id == null || this.id.isEmpty()) {
            Random random = new Random();
            int numeros = 100 + random.nextInt(900); // 100–999
            char letra1 = (char) ('A' + random.nextInt(26));
            char letra2 = (char) ('A' + random.nextInt(26));
            char letra3 = (char) ('A' + random.nextInt(26));
            this.id = String.format("%03d%c%c%c", numeros, letra1, letra2, letra3);
        }
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

    public String getDataSaidaFormatada() {
        if (dataSaida == null) return null;
        return new SimpleDateFormat("dd/MM/yyyy").format(dataSaida);
    }
}
