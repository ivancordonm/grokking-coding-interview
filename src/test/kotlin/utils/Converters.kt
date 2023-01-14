package utils

fun String.intArrayConverter() = split(",").map { it.toInt() }.toIntArray()
