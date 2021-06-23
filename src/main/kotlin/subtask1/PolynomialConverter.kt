package subtask1

import java.lang.StringBuilder

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        /*@Test
        fun testConvertToString1() {
            val result = converter.convertToStringFrom(arrayOf(2, -1, 78))
            assertEquals("2x^2 - x + 78", result)
        }*/
        // (if y<2 nx) (if y = 0 n) else nx^y
        val str = StringBuilder("")
        for(i in numbers){
            if((numbers.size - numbers.indexOf(i) - 1 ) == 1){
                //   -/+ cases
                if(i>0)
                    str.append("${i}x ")
                if(i<0)
                    str.append("${i}x ")
            }
            if ((numbers.size - numbers.indexOf(i) - 1 ) == 0){
                str.append("$i ")
            }
            if ((numbers.size - numbers.indexOf(i) - 1 ) > 1){
                str.append("${i}x^${(numbers.size - numbers.indexOf(i) - 1 )} ")
            }
        }
        return str.toString()
        //throw NotImplementedError("Not implemented")
    }
}
