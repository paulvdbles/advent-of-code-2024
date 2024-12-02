package advent

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {
    val exampleInput = Resources.readFileWithMultipleLinesSpaceSeparated("day2/example")
    val input = Resources.readFileWithMultipleLinesSpaceSeparated("day2/input")

    @Test
    fun `Day 2 solution 1 example`() {
        val result = Day2().solution1(exampleInput)
        assertEquals(2, result)
    }


    @Test
    fun `Day 2 solution 2 example`() {
        val result = Day2().solution2(exampleInput)
        assertEquals(4, result)
    }

    @Test
    fun `Day 2 solution 2 `() {
        val result = Day2().solution2(input)
        assertEquals(561, result)
    }


    @Test
    fun `Day 2 solution 1 `() {
        val result = Day2().solution1(input)
        assertEquals(516, result)
    }
}