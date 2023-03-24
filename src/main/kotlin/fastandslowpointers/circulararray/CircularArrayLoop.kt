package fastandslowpointers.circulararray

fun circularArrayLoop(nums: IntArray): Boolean {

    nums.forEachIndexed { i, n ->
        val isPositive = n >= 0
        var slow = i
        var fast = i
        while (true) {
            slow = if (isPositive) (slow + nums[slow]) % nums.size else (slow + nums[slow] + nums.size) % nums.size
            if ((nums[slow] >= 0) xor isPositive) break
            fast = if (isPositive) (fast + nums[fast]) % nums.size else (fast + nums[fast] + nums.size) % nums.size
            if ((nums[fast] >= 0) xor isPositive) break
            fast = if (isPositive) (fast + nums[fast]) % nums.size else (fast + nums[fast] + nums.size) % nums.size
            if ((nums[fast] >= 0) xor isPositive) break
            if (fast == slow) return true
        }
    }
    return false

}
