package utils

fun String.intArrayConverter() = split(",").map { it.toInt() }.toIntArray()

fun String.listStringConverter() = split(",").map { it.trim() }

fun String.setStringConverter() = split(",").map { it.trim() }.toSet()
