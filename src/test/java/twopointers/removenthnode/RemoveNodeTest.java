package twopointers.removenthnode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.LinkedList;
import utils.LinkedListConverter;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RemoveNodeTest {

    @CsvSource(value = {
        "23,28,10,5,67,39,70,28;2;23,28,10,5,67,39,28",
        "34,53,6,95,38,28,17,63,16,76;3;34,53,6,95,38,28,17,16,76",
        "69,8,49,106,116,112;6;8,49,106,116,112"
    }, delimiter = ';')
    @ParameterizedTest(name = "Test {index} => input = {0}, n = {1}, expected = {2}")
    void removeNthFromEnd(@ConvertWith(LinkedListConverter.class) LinkedList<Integer> input, int n,
                          @ConvertWith(LinkedListConverter.class) LinkedList<Integer> expected) {
        RemoveNode removeNode = new RemoveNode();
        System.out.println("input: " + input.head);
        LinkedListNode<Integer> result = removeNode.removeNthLastNode(input.head, n);
        System.out.println("expected: " + expected.head);
        System.out.println("result: " + result);
        assertIterableEquals(expected, result);
    }

}
