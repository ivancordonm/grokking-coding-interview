package utils;

import org.junit.jupiter.api.Test;

public class LinkedListReversalTest {

    @Test
    void test() {
        var list = new Integer[]{2, 4, 6, 8, 10};
        var linkedList = new LinkedList<Integer>();
        linkedList.createLinkedList(list);
        var rev = new LinkedListReversal<Integer>();
        var revHead = rev.reverseLinkedList(linkedList.head);
        System.out.println(revHead);
    }
}
