import kotlin.math.pow

fun main() {
    fun part1(batteryBanks: List<List<Int>>): Int =
        batteryBanks.sumOf(::joltage)

    fun part2(batteryBanks: List<List<Int>>): Long =
        batteryBanks.sumOf(::MAXIMUM_JOLTAGE)

    val input = readInput("Day03").map { line ->
        line.map(Char::digitToInt)
    }

    println(part1(input))
    println(part2(input))
}

fun joltage(batteryBank: List<Int>): Int {
    val firstDigit = batteryBank.dropLast(1).max()
    val firstIndex = batteryBank.indexOf(firstDigit)
    val secondDigit = batteryBank.drop(firstIndex + 1).max()
    return firstDigit * 10 + secondDigit
}

fun MAXIMUM_JOLTAGE(batteryBank: List<Int>, numberOfBatteries: Int = 12): Long {
    if (numberOfBatteries == 2) { return joltage(batteryBank).toLong() }
    val firstDigit = batteryBank.dropLast(numberOfBatteries - 1).max()
    val firstIndex = batteryBank.indexOf(firstDigit)
    val remainingJoltage = MAXIMUM_JOLTAGE(batteryBank.drop(firstIndex + 1), numberOfBatteries - 1)
    return firstDigit * 10.toDouble().pow(numberOfBatteries - 1).toLong() + remainingJoltage
}
