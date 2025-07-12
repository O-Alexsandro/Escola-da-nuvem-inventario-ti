package com.projeto_aws.Inventarioti.domain.modeloMemoria;

public enum TipoModeloMemoria {
    DDR1("DDR1"),
    DDR2("DDR2"),
    DDR3("DDR3"),
    DDR4("DDR4"),
    DDR5("DDR5");

    private final String tipoModeloMemoria;

    TipoModeloMemoria(String tipoModeloMemoria) {
        this.tipoModeloMemoria = tipoModeloMemoria;
    }
}
