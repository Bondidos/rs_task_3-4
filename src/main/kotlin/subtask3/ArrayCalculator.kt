package subtask3

class ArrayCalculator {
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        val items = mutableListOf<Int>()                                        // list of values (coefficients)
        val map = mutableMapOf<Int,List<Int>>()                                 // mapOf<Result: Int, List<coefficient_1: Int,coefficient_2: Int>>

        itemsFromArray.forEach { if (it.checkForNonIntItem()) items.add(it as Int) } //copy coefficients into List, filter not Int

        for(i in items.indices){                                        // get map where key = coefficient_1 * coefficient_2, value = coefficient_1,coefficient_2
            for(j in i until items.size){                               //
                if(i==j) continue
                val buffer = (items[i] * items[j])                      //
                val coefficients = listOf(items[i],items[j])            //
                map[buffer] = coefficients                              //
            }
        }
        return when{
            items.isEmpty()         -> 0
            numberOfItems > items.size -> countPairsMultiply(items.size,items,map)
            else -> countPairsMultiply(numberOfItems,items,map)
        }
    }
}
fun Any.checkForNonIntItem() = this is Int
fun MutableList<Int>.removeItems(list: List<Int>){
    this.remove(list[0])
    this.remove(list[1])
}
fun countPairsMultiply(numberOfItems: Int,items: MutableList<Int>,map: MutableMap<Int,List<Int>>): Int{
    var result =1
    val count = numberOfItems/2                                     // get number of pairs of coefficients
    for (item in 1 .. count) {                                      //
        result *= map.keys.max() ?: 1                               // multiply MAX pairs of coefficients count times
        items.removeItems(map.getValue(map.keys.max() ?: 1) )   // remove multiplied coefficients from list of coefficients
        map.keys.remove(map.keys.max())                             // remove Max pair using key from MAP
    }
    return if (numberOfItems%2 == 0) result else result * (items.max() ?: 1)
}