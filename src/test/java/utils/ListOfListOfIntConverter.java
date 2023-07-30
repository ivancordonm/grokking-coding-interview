package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ListOfListOfIntConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                "The argument should be a string: " + source);
        }

        // Return a list of lists of integers
        return Arrays.stream(s.split(":"))
                     .map(list -> list.trim().isEmpty() ?
                         Collections.emptyList() :
                         Arrays.stream(list.split(","))
                               .map(Integer::parseInt)
                               .collect(Collectors.toList()))
                     .collect(Collectors.toList());
    }
}
