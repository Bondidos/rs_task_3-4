package subtask3

class ArrayCalculator {
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var result = 0
        val items = mutableListOf<Int>()
        val map = mutableMapOf<Int,List<Int>>()
                          //<resultOfMult, coeffecients>
        itemsFromArray.forEach { if (it.checkForNonIntItem()) items.add(it as Int) }

        for(i in items.indices){
            for(j in i until items.size){
                if(i==j) continue
                val buffer = (items[i] * items[j])
                val coefficients = listOf(items[i],items[j])
                map[buffer] = coefficients
            }
        }
        items.forEach { println(it) }
        map.forEach { println(it) }
        return result
    }
}
fun Any.checkForNonIntItem() = this is Int

