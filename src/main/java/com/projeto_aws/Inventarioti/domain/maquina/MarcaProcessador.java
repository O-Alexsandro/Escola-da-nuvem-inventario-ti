package com.projeto_aws.Inventarioti.domain.maquina;

public enum MarcaProcessador {
    AMD("Amd"),
    INTEL("Intel");

    final String marcaProcessador;

    MarcaProcessador(String marcaProcessador) {
        this.marcaProcessador = marcaProcessador;
    }
}
