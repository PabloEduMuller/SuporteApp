package com.example.suporteapp.model;

public class Chamado {
    private String departamento;
    private String nomeSolicitante;
    private String ocorrencia;
    private String urgencia;
    private String nomeFuncionario;
    private String telefoneFuncionario;

    // Construtor
    public Chamado(String departamento, String nomeSolicitante, String ocorrencia, String urgencia,
                   String nomeFuncionario, String telefoneFuncionario) {
        this.departamento = departamento;
        this.nomeSolicitante = nomeSolicitante;
        this.ocorrencia = ocorrencia;
        this.urgencia = urgencia;
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
    }

    // Getters e Setters
    public String getDepartamento() {
        return departamento;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }
}
