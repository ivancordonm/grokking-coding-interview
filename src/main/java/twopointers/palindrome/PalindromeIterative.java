package twopointers.palindrome;

public class PalindromeIterative {

    public boolean isPalindrome(String s) {
        var pInit = 0;
        var pLast = s.length() - 1;
        while (pInit < pLast) {
            if (s.charAt(pInit) != s.charAt(pLast)) {
                return false;
            }
            pInit++;
            pLast--;
        }
        return true;
    }

}
