package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

import static java.util.Collections.emptyList;

public class ListIntConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source == null) return emptyList();
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                "The argument should be a string: " + source);
        }
        return Arrays.stream(s.split(","))
                     .map(String::trim)
                     .mapToInt(Integer::parseInt)
                     .boxed().toList();
    }
}
