package kwaymerge.mergeksorted;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.LinkedList;
import utils.LinkedListConverter;
import utils.LinkedListNode;
import utils.ListOfLinkedListConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MergeSortListTest {

    @CsvSource(value = {
        "21,23,42:1,2,4;1,2,4,21,23,42",
        "11,41,51:21,23,42;11,21,23,41,42,51",
        "2:1,2,4:25,56,66,72;1,2,2,4,25,56,66,72",
        "2:2:1,2,4;1,2,2,2,4"
    }, delimiter = ';')
    @ParameterizedTest(name = "mergeKSortedLists({1}) = {2}")
    void shouldMergeKSortedLists(@ConvertWith(ListOfLinkedListConverter.class) List<LinkedList<Integer>> lists,
                                 @ConvertWith(LinkedListConverter.class) LinkedList<Integer> expected) {
        // given
        MergeSortList mergeSortList = new MergeSortList();

        // when
        LinkedListNode<Integer> result = mergeSortList.mergeKLists(lists);

        // then
        assertIterableEquals(expected.head, result);
    }

}
