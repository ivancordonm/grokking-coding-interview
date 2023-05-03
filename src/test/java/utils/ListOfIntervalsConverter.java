package utils;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListOfIntervalsConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                "The argument should be a string: " + source);
        }

        return Arrays.stream(s.split(";"))
                     .map(str -> Arrays.stream(str.split(","))
                                       .map(interval -> interval.split(":"))
                                       .map(interval -> new Interval(Integer.parseInt(interval[0]),
                                           Integer.parseInt(interval[1])))
                         .collect(Collectors.toList()))
                     .collect(Collectors.toList());
    }
}
