package slidingwindow.repeateddnasequence

fun getRepeatedSeq(dna: String, k: Int) : List<String> {
    val counter = mutableMapOf<String, Int>() // LinkedHashmap. It's not necessary obtain hash from the key
    dna.windowed(k, 1).forEach{
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    return counter.filterValues { it > 1 }.keys.toList()
}

fun getRepeatedSeq2(dna: String, k: Int) = dna.windowed(k, 1).groupingBy { it }.eachCount().filterValues { it > 1 }.keys.toList()
