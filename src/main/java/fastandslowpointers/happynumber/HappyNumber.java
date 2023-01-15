package fastandslowpointers.happynumber;

public class HappyNumber {

    public boolean isHappyNumber(int n) {
        var fast = sumDigits(n);
        while (fast != 1 && n != fast) {
            n = sumDigits(n);
            fast = sumDigits(sumDigits(fast));
        }
        return fast == 1;
    }

    private int sumDigits(int number) {
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        return totalSum;
    }

}
