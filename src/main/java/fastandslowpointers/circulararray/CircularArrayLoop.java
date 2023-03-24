package fastandslowpointers.circulararray;

public class CircularArrayLoop {

    public boolean isCircularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean isPositive = nums[i] >= 0;
            int slow = i;
            int fast = i;
            while (true) {
                slow = isPositive ? (slow + nums[slow]) % nums.length : (slow + nums[slow] + nums.length) % nums.length;
                if (nums[slow] >= 0 ^ isPositive) break;
                fast = isPositive ? (fast + nums[fast]) % nums.length : (fast + nums[fast] + nums.length) % nums.length;
                if (nums[fast] >= 0 ^ isPositive) break;
                fast = isPositive ? (fast + nums[fast]) % nums.length : (fast + nums[fast] + nums.length) % nums.length;
                if (nums[fast] >= 0 ^ isPositive) break;
                if (fast == slow) return true;
            }
        }
        return false;
    }

}
