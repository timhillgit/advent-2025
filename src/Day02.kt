fun main() {
    fun part1(input: List<LongRange>): Long =
        input.sumOf { range ->
            range.filter(::isFraudulent).sum()
        }

    fun part2(input: List<LongRange>): Long =
        input.sumOf { range ->
            range.filter(::isFraudulentExtended).sum()
        }

    val input = readInput("Day02").single().split(',').map { rangeString ->
        val endpoints = rangeString.split('-')
        endpoints.first().toLong()..endpoints.last().toLong()
    }

    println(part1(input))
    println(part2(input))
}

fun isFraudulent(id: Long): Boolean {
    val (start, end) = id.toString().bisect()
    return start == end
}

fun isFraudulentExtended(id: Long): Boolean {
    val digits = id.toString()
    return (2..digits.length).any { numberOfParts ->
        val chunkSize = (digits.length + 1) / numberOfParts
        digits.chunked(chunkSize).distinct().size == 1
    }
}

fun String.bisect(): Pair<String, String> {
    val midpoint = length / 2
    return substring(0, midpoint) to substring(midpoint)
}
