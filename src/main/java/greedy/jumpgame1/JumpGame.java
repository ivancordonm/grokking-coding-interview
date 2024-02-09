package greedy.jumpgame1;

public class JumpGame {

    public boolean jumpGame(int[] nums) {

        int index = nums.length - 1, prevIndex = nums.length - 1;
        while (prevIndex > 0) {
            prevIndex--;
            if (nums[prevIndex] >= index - prevIndex) index = prevIndex;
        }
        return prevIndex == index;
    }
}
