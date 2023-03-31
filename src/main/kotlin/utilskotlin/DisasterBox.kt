package utilskotlin

private fun checkNull() {

    val node: LinkedListNode<Int>? = LinkedListNode(2)

    while (node?.next != null) {
        println("I'm in")
    }

}

fun main() {
    checkNull()
}
