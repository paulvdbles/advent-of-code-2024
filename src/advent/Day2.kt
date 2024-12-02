package advent

import kotlin.math.abs

class Day2 {
    fun solution1(input: List<List<String>>): Int {
        val reports = input.map { it.map { it.toInt() } }
        var result = 0
        for (report in reports) {
            val diffs = calculateDiffs(report)

            val allIncreasing = allIncreasing(report)
            val allDecreasing = allDecreasing(report)
            val diffAtLeastOne = diffAtLeastOne(diffs)
            val diffAtMostThree = diffAtMostThree(diffs)

            if ((allIncreasing and !allDecreasing) or (!allIncreasing and allDecreasing)) {
                if (diffAtLeastOne && diffAtMostThree) {
                    result += 1
                }
            }

        }
        return result
    }


    fun solution2(input: List<List<String>>): Int {
        val reports = input.map { it.map { it.toInt() } }
        var result = 0
        for (report in reports) {
            val variations = createVariations(report)
            var variationPossible = false
            for (variation in variations) {
                val diffs = calculateDiffs(variation)

                val allIncreasing = allIncreasing(variation)
                val allDecreasing = allDecreasing(variation)
                val diffAtLeastOne = diffAtLeastOne(diffs)
                val diffAtMostThree = diffAtMostThree(diffs)

                if ((allIncreasing and !allDecreasing) or (!allIncreasing and allDecreasing)) {
                    if (diffAtLeastOne && diffAtMostThree) {
                        variationPossible = true
                    }
                }
            }
            if (variationPossible) {
                result += 1
            }

        }
        return result
    }

    fun allIncreasing(input: List<Int>): Boolean = input.sorted() == input

    fun allDecreasing(input: List<Int>): Boolean = input.sortedDescending() == input

    private fun calculateDiffs(
        input: List<Int>,
    ): MutableList<Int> {
        val diffs: MutableList<Int> = mutableListOf()
        input.forEachIndexed { index, level ->
            if (index != 0) {
                diffs.add(abs(level - input[index - 1]))
            }
        }
        return diffs
    }

    fun diffAtLeastOne(diffs: List<Int>): Boolean {
        return diffs.all { it >= 1 }
    }

    fun diffAtMostThree(diffs: List<Int>): Boolean {
        return diffs.all { it <= 3 }
    }

    private fun createVariations(report: List<Int>): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()
        report.forEachIndexed { index, i ->
            val new = report.toMutableList()
            new.removeAt(index)
            results.add(new)
        }

        return results
    }
}