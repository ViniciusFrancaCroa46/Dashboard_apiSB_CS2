package com.fiap.dashboard.api.model;

import jakarta.persistence.*;

@Entity
@Table(name="Operador")
public class Operador {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    //Construtores
    public Operador() {}

    public Operador(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

}
