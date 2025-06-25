package com.projeto_aws.Inventarioti.domain.maquina;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FrequenciaMemoria {
    _200("200"),
    _266("266"),
    _333("333"),
    _400("400"),
    _533("533"),
    _667("667"),
    _800("800"),
    _1066("1066"),
    _1333("1333"),
    _1600("1600"),
    _1866("1866"),
    _2133("2133"),
    _2400("2400"),
    _2666("2666"),
    _2933("2933"),
    _3200("3200"),
    _4800("4800"),
    _5200("5200"),
    _6000("6000"),
    _6400("6400");

    private final String frequenciaMemoria;

    FrequenciaMemoria(String frequenciaMemoria) {
        this.frequenciaMemoria = frequenciaMemoria;
    }

    /** Valor que vai para JSON/banco (“3200” etc.) */
    @JsonValue
    public String getFrequenciaMemoria() {
        return frequenciaMemoria;
    }

    /** Converte do texto recebido (“3200”) para o enum correspondente */
    @JsonCreator
    public static FrequenciaMemoria fromFrequenciaMemoria(String frequenciaMemoria) {
        for (FrequenciaMemoria f : values()) {
            if (f.frequenciaMemoria.equals(frequenciaMemoria)) return f;
        }
        throw new IllegalArgumentException("Frequência inválida: " + frequenciaMemoria);
    }
}

