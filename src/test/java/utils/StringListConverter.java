package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class StringListConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if(!(source instanceof String s)) {
            throw new IllegalArgumentException("The argument should be a string: " + source);
        }
        if(s.isBlank()) {
            return emptyList();
        }
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
