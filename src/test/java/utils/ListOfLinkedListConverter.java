package utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;


public class ListOfLinkedListConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String s)) {
            throw new ArgumentConversionException("The source is not a String");
        }

        return Arrays.stream(s.split(":")).map(this::convertToLinkedList).toList();
    }

    private LinkedList<Integer> convertToLinkedList(String s) {
        var intArray = Arrays.stream(s.split(","))
                             .map(String::trim)
                             .map(Integer::parseInt)
                             .toArray(Integer[]::new);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.createLinkedList(intArray);
        return linkedList;
    }
}
