import java.io.File

fun main(args: Array<String>) {
    val uri = Unit.javaClass.getResource("/input.txt").toURI()
    var validCount = File(uri)
            .readLines()
            .asSequence()
            .count { isValidPass(it) }
    println("Result: $validCount")
}

fun isValidPass(line: String): Boolean {
    val original = line.split("\\s+".toRegex())
    val set = original.toHashSet()
    return original.size == set.size
}

