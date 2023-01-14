package twopointers.palindrome

fun isPalindromeIterative(s: String): Boolean {
    var low = 0
    var high = s.lastIndex
    while (low < high) {
        if (s[low] != s[high]) return false
        low++
        high--
    }
    return true
}

fun isPalindromeRecursive(s: String): Boolean {
    if(s.length <= 1) return true
    return (s.first() == s.last()) && isPalindromeRecursive(s.substring(1, s.lastIndex))
}
