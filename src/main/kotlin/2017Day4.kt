package d4

import java.io.File

fun main(args: Array<String>) {
    val input = File(Unit.javaClass.getResource("/input_2017_day4.txt").toURI())
    part1(input)
    part2(input)
}

fun part1(input: File) {
    var validCount = input
            .readLines()
            .asSequence()
            .count { isValidPass(it) }
    println("Part 1 Result: $validCount")
}

fun isValidPass(line: String): Boolean {
    val original = line.split("\\s+".toRegex())
    val set = original.toHashSet()
    return original.size == set.size
}

fun part2(input: File) {
    var validCount = input
            .readLines()
            .asSequence()
            .count { isValidPassPart2(it) }
    println("Part 2 Result: $validCount")
}

fun isValidPassPart2(line: String): Boolean {
    val original = line.split("\\s+".toRegex())

    val set = original.asSequence()
            .map { s ->
                s.asSequence()
                        .sorted()
                        .map { s -> s.toString() }
                        .reduce { acc, s -> acc + s }
            }
            .toHashSet()
    return original.size == set.size
}

