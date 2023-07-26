package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class IntervalsToListConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source == null) {
            return emptyList();
        }

        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                "The argument should be a string: " + source);
        }

        return Arrays.stream(s.split(",")).map(interval -> interval.split(":"))
                     .map(interval -> List.of(Integer.parseInt(interval[0]), Integer.parseInt(interval[1])))
                     .collect(Collectors.toList());
    }
}
