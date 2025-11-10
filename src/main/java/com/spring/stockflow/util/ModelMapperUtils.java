package com.spring.stockflow.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, T> D map(T dto, Class<D> outClass) {
        return modelMapper.map(dto, outClass);
    }
}
