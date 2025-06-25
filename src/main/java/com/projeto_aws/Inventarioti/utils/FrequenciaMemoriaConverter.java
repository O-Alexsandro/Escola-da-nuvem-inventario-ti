package com.projeto_aws.Inventarioti.utils;

import com.projeto_aws.Inventarioti.domain.maquina.FrequenciaMemoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FrequenciaMemoriaConverter
        implements AttributeConverter<FrequenciaMemoria, String> {

    @Override
    public String convertToDatabaseColumn(FrequenciaMemoria atributo) {
        return (atributo == null) ? null : atributo.getFrequenciaMemoria();
    }

    @Override
    public FrequenciaMemoria convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : FrequenciaMemoria.fromFrequenciaMemoria(dbData);
    }
}

