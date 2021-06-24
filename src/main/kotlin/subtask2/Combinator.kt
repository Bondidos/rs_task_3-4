package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        // m - number posters to design array[0]
        // n - total of available colors    array[1]
        // x - number of color combinations for posters
        // m = x number of combinations is exactly the same as the number of posters
        // In other words you should create a function which takes m(*Int*) and n(*Int*)
        // and returns x(*Int*). Some more conditions: m >= 0 and n > 0. If many x are solutions
        // give as result the smallest x. It can happen that when m is given at random there are no
        // x satisfying equation (1) then return *null*.
        for ( i in 0 .. array[0]) {
            println(factorial(array[1]) / factorial(i) * factorial(array[1] - i).toInt())
        }
        throw NotImplementedError("Not implemented")
    }
}
//todo write method to calculate factorial
private fun factorial(num: Int): Double{
    var result = 1.0
    for(i in 1 .. num){
        result *= i
    }
    return result
}