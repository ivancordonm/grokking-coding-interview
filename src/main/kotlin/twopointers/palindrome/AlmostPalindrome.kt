package twopointers.palindrome

fun isAlmostPalindrome(s: String): Boolean {
    var low = 0
    var high = s.lastIndex
    var canContinue = true
    while (low < high) {
        if (s[low] != s[high]) {
            if (canContinue) {
                if (low == high - 1) return true
                canContinue = false
                if (s[low + 1] == s[high]) low++
                else if (s[low] == s[high - 1]) high--
                else return false
            } else return false
        }
        low++
        high--
    }
    return true
}
