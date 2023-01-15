package twopointers.palindrome;

public class AlmostPalindrome {

    public boolean isPalindrome(String s) {

        var low = 0;
        var high = s.length() - 1;
        var canContinue = true;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                if (canContinue) {
                    if (low == high - 1) return true;
                    canContinue = false;
                    if (s.charAt(low + 1) == s.charAt(high)) low++;
                    else if (s.charAt(low) == s.charAt(high - 1)) high--;
                    else return false;
                } else return false;
            }
            low++;
            high--;
        }
        return true;
    }

}
