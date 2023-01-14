package twopointers.sumofthree

fun isSumOfThree(nums: IntArray, target: Int): Boolean {
    nums.sort()
    nums.dropLast(1).forEachIndexed { index, _ ->
        run {
            var low = index + 1
            var high = nums.lastIndex
            while (low < high) {
                val triplet = nums[index] + nums[low] + nums[high]
                when (true) {
                    (triplet == target) -> {
                        println("${nums[index]} + ${nums[low]} + ${nums[high]} = $target")
                        return true
                    }
                    (triplet < target) -> low++
                    else -> high--
                }
            }
        }
    }
    return false
}
