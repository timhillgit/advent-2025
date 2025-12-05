fun main() {
    fun part1(ingredientIds: List<Long>, freshRanges: List<LongRange>): Int =
        ingredientIds.count { ingredient ->
            freshRanges.any { range -> ingredient in range}
        }

    fun part2(freshRanges: List<LongRange>): Int {
        return 0
    }

    val input = readInput("Day05")
    val dividerIndex = input.indexOf("")
    val freshRanges: List<LongRange> = input.subList(0, dividerIndex).map { range ->
        val endpoints = range.split('-')
        endpoints.first().toLong()..endpoints.last().toLong()
    }
    val ids: List<Long> = input.subList(dividerIndex + 1, input.size).map(String::toLong)

    println(part1(ids, freshRanges))
    println(part2(freshRanges))
}
