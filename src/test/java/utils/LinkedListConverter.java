package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class LinkedListConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new ArgumentConversionException("The source is not a String");
        }
        //create Integer array from String
        Integer[] intArray = Arrays.stream(s.split(","))
                                   .map(String::trim)
                                   .map(Integer::parseInt)
                                   .toArray(Integer[]::new);
        var linkedList = new LinkedList<Integer>();
        linkedList.createLinkedList(intArray);
        return linkedList;
    }

}
