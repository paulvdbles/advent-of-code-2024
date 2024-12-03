package advent

class Day3 {
    fun solution1(input: String): Int {
        val cleanInstructions: MutableList<String> = mutableListOf()
        var stack = ""

        var cursor = 0
        while (cursor != input.length) {
            val c = input[cursor]

            if (c == '(') {
                stack += "("
                cursor += 1
            } else if (c == ')') {
                stack += ")"
                cursor += 1
                if(validateStack(stack)) {
                    cleanInstructions += stack
                    stack = ""
                }
            } else if (c == ',') {
                stack += ","
                cursor += 1
            } else if (c.digitToIntOrNull() != null) {
                stack += c
                cursor += 1
            } else if (keywordInBounds(cursor, 1, input)) {
                if (input.substring(cursor..cursor + 1).toIntOrNull() != null) {
                    stack += input.substring(cursor..cursor + 1)
                    cursor += 2
                } else if (keywordInBounds(cursor, 2, input)) {
                    if (input.substring(cursor..cursor + 2) == "mul") {
                        stack = "mul"
                        cursor += 3
                    } else if (input.substring(cursor..cursor + 2).toIntOrNull() != null) {
                        stack += input.substring(cursor..cursor + 2)
                        cursor += 3
                    }
                    else {
                        stack = ""
                        cursor += 1
                    }
                } else {
                    stack = ""
                    cursor += 1
                }
            } else {
                stack = ""
                cursor += 1
            }
        }

        return cleanInstructions.map { parse(it) }.sumOf { it.first * it.second }
    }



    fun solution2(input: String): Int {
        val cleanInstructions: MutableList<String> = mutableListOf()
        var stack = ""

        var cursor = 0
        var enabled = true
        while (cursor != input.length) {
            val c = input[cursor]

            if (c == '(') {
                stack += "("
                cursor += 1
            } else if (c == ')') {
                stack += ")"
                cursor += 1
                if(validateStack(stack)){
                    if (enabled){
                        cleanInstructions += stack
                    }
                    stack = ""
                }
            } else if (c == ',') {
                stack += ","
                cursor += 1
            } else if (c.digitToIntOrNull() != null) {
                stack += c
                cursor += 1
            } else if (keywordInBounds(cursor, 1, input)) {
                if (input.substring(cursor.. cursor+1) == "do"){
                    if (input[cursor+2] == '('){
                       enabled = true
                    } else {
                        enabled = false
                    }
                }
                if (input.substring(cursor..cursor + 1).toIntOrNull() != null) {
                    stack += input.substring(cursor..cursor + 1)
                    cursor += 2
                } else if (keywordInBounds(cursor, 2, input)) {
                    if (input.substring(cursor..cursor + 2) == "mul") {
                        stack = "mul"
                        cursor += 3
                    } else if (input.substring(cursor..cursor + 2).toIntOrNull() != null) {
                        stack += input.substring(cursor..cursor + 2)
                        cursor += 3
                    }
                    else {
                        stack = ""
                        cursor += 1
                    }
                } else {
                    stack = ""
                    cursor += 1
                }
            } else {
                stack = ""
                cursor += 1
            }
        }

        return cleanInstructions.map { parse(it) }.sumOf { it.first * it.second }
    }


    private fun parse(instruction: String): Pair<Int, Int> {
        val first = instruction.substringAfter("(", "").substringBefore(",", "").toInt()
        val second = instruction.substringAfter(",", "").substringBefore(")", "").toInt()
        return Pair(first, second)
    }

    private fun validateStack(stack: String): Boolean {
        try {
            val mul = stack.substring(0, 3)
            if (mul != "mul"){
                return false
            }
            val left = stack[3]
            if (left != '('){
                return false
            }

            val commaCount = stack.count{it == ',' }
            if (commaCount != 1){
                return false
            }

            val first = stack.substringAfter("(", "").substringBefore(",", "")
            if (first.toIntOrNull() == null){
                return false
            }

            val second = stack.substringAfter(",", "").substringBefore(")", "")
            if (second.toIntOrNull() == null){
                return false
            }

            val right = stack[stack.length-1]
            if (right != ')'){
                return false
            }

            return true
        } catch (e: Exception){
            return false
        }
    }

    private fun keywordInBounds(index: Int, offset: Int, input: String) = index + offset <= input.length - 1
}