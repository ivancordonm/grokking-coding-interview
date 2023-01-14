package twopointers.palindrome;

public class PalindromeIterative {

    public boolean isPalindrome(String s) {
        var low = 0;
        var high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}
