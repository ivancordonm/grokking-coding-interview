package utilskotlin

data class LinkedListNode<T>(val data: T, var next: LinkedListNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$data -> $next"
        } else {
            "$data"
        }
    }
}
