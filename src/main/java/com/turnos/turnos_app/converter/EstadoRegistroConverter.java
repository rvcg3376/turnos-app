package com.turnos.turnos_app.converter;

import com.turnos.EstadoRegistro;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoRegistroConverter implements AttributeConverter<EstadoRegistro, Integer> {


    @Override
    public Integer convertToDatabaseColumn(EstadoRegistro estado) {
        return estado != null ? estado.getCodigo() : null;
    }

    @Override
    public EstadoRegistro convertToEntityAttribute(Integer codigo) {
        return codigo != null ? EstadoRegistro.fromCodigo(codigo) : null;
    }

}
