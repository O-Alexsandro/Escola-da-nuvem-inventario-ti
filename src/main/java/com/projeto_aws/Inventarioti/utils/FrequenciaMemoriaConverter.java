package com.projeto_aws.Inventarioti.utils;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.TipoFrequenciaMemoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FrequenciaMemoriaConverter
        implements AttributeConverter<TipoFrequenciaMemoria, String> {

    @Override
    public String convertToDatabaseColumn(TipoFrequenciaMemoria attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValor(); // "1066", "3200", etc
    }

    @Override
    public TipoFrequenciaMemoria convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TipoFrequenciaMemoria.fromJson(dbData);
    }
}

