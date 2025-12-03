fun main() {
    fun part1(input: List<String>): Int {
        var position = 50
        var numberOfZeroes = 0
        for (line in input) {
            val clicks = line.substring(1).toInt()
            if (line[0] == 'L') {
                position -= clicks
            } else {
                position += clicks
            }
            position = position.mod(100)
            if (position == 0) { numberOfZeroes += 1}
        }

        return numberOfZeroes
    }

    fun part2(input: List<String>): Int {
        var position = 50
        var numberOfZeroes = 0
        for (line in input) {
            val clicks = line.substring(1).toInt()
            val endPosition = if (line[0] == 'L') {
                position - clicks
            } else {
                position + clicks
            }
            numberOfZeroes += if (endPosition > 0) {
                endPosition / 100
            } else if (position == 0) {
                (endPosition / -100)
            } else {
                (endPosition / -100) + 1
            }
            position = endPosition.mod(100)
        }

        return numberOfZeroes
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
