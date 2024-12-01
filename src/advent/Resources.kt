package advent

import java.io.File

internal object Resources {
    fun readFileAsLines(fileName: String): List<String> =
            File(Resources.javaClass.classLoader.getResource(fileName)!!.toURI()).useLines { it.toList() }

    fun readFileAsPairs(fileName: String): List<Pair<Int, Int>> =
        File(Resources.javaClass.classLoader.getResource(fileName)!!.toURI()).useLines { it.toList() }.map { parseTabSpacedPair(it) }

    private fun parseTabSpacedPair(line: String) : Pair<Int, Int> {
        val split = line.split("   ")
        return Pair(split[0].toInt(), split[1].toInt())
    }

    fun readFileCommaSeparated(fileName: String): List<String> =
            File(Resources.javaClass.classLoader.getResource(fileName)!!.toURI()).readText(Charsets.UTF_8).split(",").map { it.trim() }

    fun readFileRange(fileName: String): List<Int> =
            File(Resources.javaClass.classLoader.getResource(fileName)!!.toURI()).readText(Charsets.UTF_8).split("-").map { it.trim() }.map { it.toInt() }

    fun readFileWithMultipleLinesCommaSeparated(fileName: String): List<List<String>> {
        val file = File(Resources.javaClass.classLoader.getResource(fileName)!!.toURI())
        val lines = file.useLines { line -> line.toList() }
        val valuesPerLine = mutableListOf<MutableList<String>>()
        lines.forEach { line ->
            val allValuesFromLine = mutableListOf<String>()
            line.split(",").map { it.trim() }.forEach { allValuesFromLine.add(it) }
            valuesPerLine.add(allValuesFromLine)
        }
        return valuesPerLine
    }


    fun readStringCommaSeparated(value: String): List<String> =
            value.split(",").map { it.trim() }
}