package fastandslowpointers.middlenode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utilskotlin.LinkedList
import java.util.stream.Stream

class MiddleNodeKtTest {

    companion object {

        @JvmStatic
        fun listAndResultProvider(): Stream<Arguments> = Stream.of(
            arguments(arrayOf(1, 2, 3, 4, 5), 3),
            arguments(arrayOf(1, 2, 3, 4, 5, 6), 4),
            arguments(arrayOf(3, 2, 1), 2),
            arguments(arrayOf(10), 10),
            arguments(arrayOf(1, 2), 2)
        )
    }

    @ParameterizedTest(name = "#{index} with list {0}")
    @MethodSource("listAndResultProvider")
    fun getTheMiddle(nodes: Array<Int>, result: Int) {
        val linkedList = LinkedList<Int>()
        linkedList.createLinkedList(nodes)
        assertEquals(result, getMiddle(linkedList.head!!))
    }
}
