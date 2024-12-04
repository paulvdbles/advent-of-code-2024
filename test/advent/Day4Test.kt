package advent

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day4Test {

    @Test
    fun solution1() {
        val input = Resources.readFileAsLines("day4/input")
        val result = Day4().solution1(input)
        assertEquals(2500, result)
    }

    @Test
    fun `Problem 1 example`() {
        val input = Resources.readFileAsLines("day4/example")
        val result = Day4().solution1(input)
        assertEquals(18, result)
    }


    @Test
   fun `Problem 2 example`() {
        val input = Resources.readFileAsLines("day4/example2")
        val result = Day4().solution2(input)
        assertEquals(9, result)
    }


    @Test
    fun `Problem 2 `() {
        val input = Resources.readFileAsLines("day4/input")
        val result = Day4().solution2(input)
        assertEquals(1933, result)
    }
}