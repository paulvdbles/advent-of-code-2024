package advent

import kotlin.math.abs

class Day1 {
    fun solution1(input: List<Pair<Int, Int>>): Int {
        val left: MutableList<Int> = mutableListOf()
        val right: MutableList<Int> = mutableListOf()

        input.forEach {
            left += it.first
            right += it.second
        }

        val size = left.size
        val result: MutableList<Int> = mutableListOf()

        for (i in 0 until size) {
            val smallestLeft = left.min()
            val smallestRight = right.min()
            left.remove(smallestLeft)
            right.remove(smallestRight)
            val distance = abs(smallestLeft - smallestRight)
            result.add(distance)
        }

        return result.sum()
    }

    fun solution2(input: List<Pair<Int, Int>>): Int {
        val left: MutableList<Int> = mutableListOf()
        val right: MutableList<Int> = mutableListOf()

        input.forEach {
            left += it.first
            right += it.second
        }

        var result = 0
        left.forEach { n ->
            val count = right.count { n == it }
            result += count * n
        }

        return result
    }
}