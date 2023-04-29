package utils;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class IntervalConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }

        var interval = s.split(":");
        return new Interval(Integer.parseInt(interval[0]), Integer.parseInt(interval[1]));
    }
}
