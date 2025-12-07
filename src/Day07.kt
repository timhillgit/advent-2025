fun main() {
    fun part1(manifold: List<String>): Int {
        val startingPosition = manifold.first().indexOf('S')
        var numSplit = 0
        val finalPositions = manifold.drop(1).fold(setOf(startingPosition)) { beamPositions, row ->
            buildSet {
                beamPositions.forEach { position ->
                    if (row[position] == '^') {
                        numSplit += 1
                        add(position - 1)
                        add(position + 1)
                    } else {
                        add(position)
                    }
                }
            }
        }

        return numSplit
    }
    val manifold = readInput("Day07")
    println(part1(manifold))
}
