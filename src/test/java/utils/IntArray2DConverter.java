package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class IntArray2DConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source == null) return new int[0][0];
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                "The argument should be a string: " + source);
        }
        return Arrays.stream(s.split(":")).map(
            row -> Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray()
        ).toArray(int[][]::new);
    }

}
