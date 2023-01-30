package fastandslowpointers.circulararray

fun circularArrayLoop(nums: IntArray): Boolean {

    var slow = 0
    var fast = 0

    slow += nums[slow]
    fast += nums[fast]
    fast += nums[fast]

    while(slow != fast) {
        slow += nums[slow]
        fast += nums[fast]
        fast += nums[fast]

    }

    return true

}
