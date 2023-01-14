package twopointers.reversestring

fun reverseString(sentence: String): String {

    val reverse = sentence.reversed().trim()
    return buildString {
        var start = 0
        var end = 0
        while (start < reverse.length) {
            while (start < reverse.length && reverse[start] != ' ') start++
            var index = start
            while (start > end) append(reverse[--start])
            if (index < reverse.lastIndex) {
                append(reverse[index])
                while (reverse[index] == ' ') index++
            }
            start = index
            end = index
        }
    }
}
