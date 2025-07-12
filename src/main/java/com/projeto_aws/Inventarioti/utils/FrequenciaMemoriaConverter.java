package com.projeto_aws.Inventarioti.utils;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.TipoFrequenciaMemoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FrequenciaMemoriaConverter
        implements AttributeConverter<TipoFrequenciaMemoria, String> {

    @Override
    public String convertToDatabaseColumn(TipoFrequenciaMemoria atributo) {
        return (atributo == null) ? null : atributo.getValor();
    }

    @Override
    public TipoFrequenciaMemoria convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : TipoFrequenciaMemoria.fromFrequenciaMemoria(dbData);
    }
}

