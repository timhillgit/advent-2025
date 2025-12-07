val WHITESPACE = Regex("\\s+")
typealias Operation = (Long, Long) -> Long

fun main() {
    fun part1(numbers: List<List<Long>>, operations: List<Operation>): Long =
        operations.withIndex().sumOf { (index, operation) ->
            numbers.map { row ->
                row[index]
            }.reduce(operation)
        }

    val input = readInput("Day06").map { line ->
        line.split(WHITESPACE)
    }
    val numbers: List<List<Long>> = input.dropLast(1).map { line ->
        line.map(String::toLong)
    }
    val operations: List<Operation> = input.last().map { op ->
        if (op == "+") {
            Long::plus
        } else {
            Long::times
        }
    }
    println(part1(numbers, operations))
}
