package fastandslowpointers.happynumber

fun isHappyNumber(n: Int): Boolean {

    fun Int.sumDigits() = toString().fold(0) { acc, c -> acc + c.digitToInt() * c.digitToInt() }

    var slow = n
    var fast = n.sumDigits()
    while (fast != 1 && fast != slow) {
        slow = slow.sumDigits()
        fast = fast.sumDigits().sumDigits()
    }
    return fast == 1
}
