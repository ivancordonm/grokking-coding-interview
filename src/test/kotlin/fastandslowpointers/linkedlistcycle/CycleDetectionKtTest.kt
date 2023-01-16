package fastandslowpointers.linkedlistcycle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utilskotlin.LinkedList
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CycleDetectionKtTest {

    private fun listAndResultProvider(): Stream<Arguments?>? {
        return Stream.of(
            Arguments.arguments(arrayOf(2, 4, 6, 8, 10), true, 0),
            Arguments.arguments(arrayOf(1, 3, 5, 7, 9), false, 1),
            Arguments.arguments(arrayOf(1, 2, 3, 4, 5), true, 2),
            Arguments.arguments(arrayOf(0, 2, 3, 5, 6), false, 3),
            Arguments.arguments(arrayOf(3, 6, 9, 10, 11), true, 4),
            Arguments.arguments(arrayOf(2, 2, 4, 5, 6, 3, 2, 4), false, 5)
        )
    }

    @ParameterizedTest(name = "#{index} Test with list {0}")
    @MethodSource("listAndResultProvider")
    fun detectCycle(nodes: Array<Int>, result: Boolean, index: Int) {
        val linkedList = LinkedList<Int>()
        linkedList.createLinkedList(nodes)
        if (index % 2 == 0) linkedList.head?.next?.next?.next?.next?.next = linkedList.head?.next
        assertEquals(result, detectCycle(linkedList.head!!))
    }

}
