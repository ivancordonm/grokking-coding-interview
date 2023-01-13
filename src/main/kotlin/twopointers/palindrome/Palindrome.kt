package twopointers.palindrome

fun isPalindromeIterative(s: String): Boolean {
    var pInit = 0
    var pLast = s.lastIndex
    while (pInit < pLast) {
        if (s[pInit] != s[pLast]) return false
        pInit++
        pLast--
    }
    return true
}

fun isPalindromeRecursive(s: String): Boolean {
    if(s.length <= 1) return true
    return (s.first() == s.last()) && isPalindromeRecursive(s.substring(1, s.lastIndex))
}
