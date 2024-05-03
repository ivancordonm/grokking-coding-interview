package twopointers.sortcolors;

public class SortColors {
    public int[] sortColors(int[] colors) {
        int current = 0;
        int start = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                swap(colors, current, start);
                current++;
                start++;
            } else if (colors[current] == 1) current++;
            else {
                swap(colors, current, end);
                end--;
            }
        }
        return colors;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
