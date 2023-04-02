package utils

fun String.intArrayConverter() = split(",").map { it.toInt() }.toIntArray()

fun String.setStringConverter() = if(isNullOrEmpty()) emptySet() else split(",").map { it.trim() }.toSet()
