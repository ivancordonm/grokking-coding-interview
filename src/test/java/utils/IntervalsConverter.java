package utils;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntervalsConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }

        var string = s.split(",");
        return IntStream.range(0, string.length / 2)
                .mapToObj(i -> new Interval(Integer.parseInt(string[i * 2]), Integer.parseInt(string[i * 2 + 1])))
                .collect(Collectors.toList());

    }
}
