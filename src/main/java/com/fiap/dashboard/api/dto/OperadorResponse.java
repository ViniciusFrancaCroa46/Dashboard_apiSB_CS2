package com.fiap.dashboard.api.dto;

public class OperadorResponse {
    private Long id;
    private String email;

    public OperadorResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
}
