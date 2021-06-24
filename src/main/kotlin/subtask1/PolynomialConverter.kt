package subtask1

import java.lang.StringBuilder
import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.isEmpty()) return null

        val str = StringBuilder("")
        for (i in numbers.indices) {
            str.append(convertToString(i,numbers))
        }
        return str.toString()
    }
}
fun convertToString(index: Int, numbers: Array<Int>): String {
    //first : calculate "k"(multiplier) from position in array
    val k = numbers.size - index - 1 //multiplier
    val str = StringBuilder("")
    when {
        index < numbers.size - 2 -> {
            when {
                numbers[index] <  0 && index != 0-> str.append("- ${abs(numbers[index])}x^$k ")
                //numbers[index] == 0              -> str.append("")
                numbers[index] >  0 && index != 0-> str.append("+ ${abs(numbers[index])}x^$k ")
                numbers[index] <  0 && index == 0-> str.append("${abs(numbers[index])}x^$k ")
                numbers[index] >  0 && index == 0-> str.append("${abs(numbers[index])}x^$k ")
            }
        }
        index == numbers.size - 2 -> {
            when{
                numbers[index] == 1              -> str.append("x ")
                numbers[index] == -1              -> str.append("- x ")
                numbers[index] <  0 -> str.append("- ${abs(numbers[index])}x ")
                numbers[index] >  0 -> str.append("+ ${abs(numbers[index])}x ")
            }
        }
        else -> when{
            numbers[index] <  0 -> str.append("- ${abs(numbers[index])}")
            numbers[index] >  0 -> str.append("+ ${abs(numbers[index])}")
        }
    }
    return str.toString()
}


