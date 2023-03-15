package com.example.autoserviceapp.util;

import java.time.Year;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        return attribute != null ? (short) attribute.getValue() : null;
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        return dbData != null ? Year.of(dbData) : null;
    }
}
