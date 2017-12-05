package d5

import java.io.File
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val input = File(Unit.javaClass.getResource("/input_2017_day5.txt").toURI())
    var steps = 0
    var speed: Long
    speed = measureTimeMillis {
        steps = part1(input)
    }
    println("Part 1 Result: $steps, took: $speed millis")

    speed = measureTimeMillis {
        steps = part2(input)
    }
    println("Part 2 Result: $steps, took: $speed millis")
}

fun part1(input: File): Int {
    var jumps = input.readLines()
            .map { s -> s.toInt() }
            .toMutableList()
    var steps = 0
    var index = 0
    while (index < jumps.size && index >= 0) {
        val value = jumps[index]
        jumps.set(index, value + 1)
        index += value
        steps += 1
    }
    return steps
}

fun part2(input: File) : Int {
    var jumps = input.readLines()
            .map { s -> s.toInt() }
            .toMutableList()
    var steps = 0
    var index = 0
    while (index < jumps.size && index >= 0) {
        val value = jumps[index]
        jumps.set(index, value + if (value >= 3) -1 else 1)
        index += value
        steps += 1
    }
    return steps
}


