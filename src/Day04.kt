fun main() {
    fun part1(rolls: Set<Pair<Int, Int>>): Int =
        rolls.count { location ->
            neighbors(location).count { it in rolls } < 4
        }

    fun part2(startingRolls: Set<Pair<Int, Int>>): Int {
        var stable = false
        val rolls = startingRolls.toMutableSet()
        while (!stable) {
            stable = !rolls.removeIf { location ->
                neighbors(location).count { it in rolls } < 4
            }
        }
        return startingRolls.size - rolls.size
    }

    val rolls: Set<Pair<Int, Int>> = buildSet {
        readInput("Day04").forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, character ->
                if (character == '@') { add(rowIndex to columnIndex) }
            }
        }
    }

    println(part1(rolls))
    println(part2(rolls))
}

fun neighbors(location: Pair<Int, Int>): Set<Pair<Int, Int>> {
    val (row, col) = location
    return setOf(
        row - 1 to col - 1,
        row - 1 to col,
        row - 1 to col + 1,
        row to col + 1,
        row + 1 to col + 1,
        row + 1 to col,
        row + 1 to col - 1,
        row to col - 1,
    )
}
