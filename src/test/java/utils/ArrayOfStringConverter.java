package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class ArrayOfStringConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new ArgumentConversionException("The source is not a String");
        }

        if (s.isBlank()) {
            return new String[0];
        }

        return s.split(",");
    }
}
