package advent

class Day4 {
    fun solution1(input: List<String>): Int {
        var count = 0
        input.forEachIndexed { lIndex, line ->
            line.forEachIndexed { cIndex, c ->
                if (c == 'X') {
                    count += horizontal(cIndex, lIndex, input)
                    count += vertical(cIndex, lIndex, input)
                    count += backwardsHorizontal(cIndex, lIndex, input)
                    count += verticalBackwards(cIndex, lIndex, input)
                    count += diagonalLeftToRight(cIndex, lIndex, input)
                    count += diagonalLeftToRightBackwards(cIndex, lIndex, input)
                    count += diagonalRightToLeft(cIndex, lIndex, input)
                    count += diagonalRightToLeftBackwards(cIndex, lIndex, input)
                }
            }
        }
        return count
    }

    private fun vertical(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex + 1][cIndex]
            val a = input[lIndex + 2][cIndex]
            val s = input[lIndex + 3][cIndex]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }


    private fun verticalBackwards(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex - 1][cIndex]
            val a = input[lIndex - 2][cIndex]
            val s = input[lIndex - 3][cIndex]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }

    private fun diagonalLeftToRight(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex + 1][cIndex + 1]
            val a = input[lIndex + 2][cIndex + 2]
            val s = input[lIndex + 3][cIndex + 3]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }


    private fun diagonalLeftToRightBackwards(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex - 1][cIndex - 1]
            val a = input[lIndex - 2][cIndex - 2]
            val s = input[lIndex - 3][cIndex - 3]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }



    private fun diagonalRightToLeft(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex + 1][cIndex - 1]
            val a = input[lIndex + 2][cIndex - 2]
            val s = input[lIndex + 3][cIndex - 3]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }


    private fun diagonalRightToLeftBackwards(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val x = input[lIndex][cIndex]
            val m = input[lIndex - 1][cIndex + 1]
            val a = input[lIndex - 2][cIndex + 2]
            val s = input[lIndex - 3][cIndex + 3]
            val combined = "$x$m$a$s"
            if (combined == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }

    private fun horizontal(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            if (input[lIndex].substring(cIndex, cIndex + 4) == "XMAS") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }

    private fun backwardsHorizontal(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            if (input[lIndex].substring(cIndex - 3, cIndex + 1) == "SAMX") {
                return 1
            } else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }

    private fun Xmas(cIndex: Int, lIndex: Int, input: List<String>): Int {
        try {
            val topLeft = input[lIndex-1][cIndex-1]
            val topRight = input[lIndex-1][cIndex+1]
            val middle = input[lIndex][cIndex]
            val bottomLeft = input[lIndex+1][cIndex-1]
            val bottomRight = input[lIndex+1][cIndex+1]
            if (topLeft == 'M' && topRight == 'S' && middle == 'A' && bottomLeft == 'M' && bottomRight == 'S') {
                return 1
            }
            else if (topLeft == 'S' && topRight == 'S' && middle == 'A' && bottomLeft == 'M' && bottomRight == 'M') {
                return 1
            }
            else if (topLeft == 'S' && topRight == 'M' && middle == 'A' && bottomLeft == 'S' && bottomRight == 'M') {
                return 1
            }
            else if (topLeft == 'M' && topRight == 'M' && middle == 'A' && bottomLeft == 'S' && bottomRight == 'S') {
                return 1
            }
            else {
                return 0
            }
        } catch (e: IndexOutOfBoundsException) {
            return 0
        }
    }



    fun solution2(input: List<String>): Int {
        var count = 0
        input.forEachIndexed { lIndex, line ->
            line.forEachIndexed { cIndex, c ->
                if (c == 'A') {
                    count += Xmas(cIndex, lIndex, input)
                }
            }
        }
        return count
    }

}