package advent

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {

    @Test
    fun solution1() {
        val input = Resources.readFileAsString("day3/input")
        val result = Day3().solution1(input)
        assertEquals(183380722, result)
    }

    @Test
    fun solution2() {
        val input = Resources.readFileAsString("day3/input")
        val result = Day3().solution2(input)
        assertEquals(82733683, result)
    }
    @Test
    fun `Problem 2 example`() {
        val input = Resources.readFileAsString("day3/example")
        val result = Day3().solution2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")
        assertEquals(48, result)
    }


    @Test
    fun `Problem 1 example`() {
        val input = Resources.readFileAsString("day3/example")
        val result = Day3().solution1(input)
        assertEquals(161, result)
    }

}