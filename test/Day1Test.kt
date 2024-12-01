import advent.Day1
import advent.Resources
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {
    val exampleInput = Resources.readFileAsPairs("day1/example")
    val input = Resources.readFileAsPairs("day1/input")

    @Test
    fun `Day 1 puzzle 1 real case`() {
        val result = Day1().solution1(input)
        assertEquals(result, 1341714)
    }

    @Test
    fun `Day 1 puzzle 1 example case`() {
        assertEquals(exampleInput.size, 6)
        val result = Day1().solution1(exampleInput)
        assertEquals( 11, result)
    }

    @Test
    fun `Day 1 puzzle 2 example case`() {
        assertEquals(exampleInput.size, 6)
        val result = Day1().solution2(exampleInput)
        assertEquals( 31, result)
    }

    @Test
    fun `Day 1 puzzle 2 real case`() {
        val result = Day1().solution2(input)
        assertEquals(result, 27384707)
    }
}