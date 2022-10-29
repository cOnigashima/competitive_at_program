package LDH;

data class DataStructure(val operations : List<Event>) {
    private val data = mutableMapOf<Int, Int>()
    private val computedKeys = mutableListOf<Int>()
    private val resultList = mutableListOf<Int>()

    private fun add(key: Int, value: Int) {
        data[key] = value
        computedKeys.add(key)
    }

    private fun get(key: Int) {
        resultList.add(data[key] ?: -1)
        computedKeys.add(key)
    }

    private fun remove(key: Int) {
        resultList.add(data.remove(key) ?: -1)
    }

    private fun evict() {
        //　これマジでむずかった
        // 先入れ先出し法にしないとダメ。
        data.remove(computedKeys.first())
    }


    fun execute(){
        operations.forEach{
            when(it){
                is Event.Add -> add(it.key,it.value)
                is Event.Get -> get(it.key)
                is Event.Remove -> remove(it.key)
                is Event.Evict -> evict()
                is Event.Exit -> {
                    exit()
                    return
                }
                is Event.Unknown -> {}
            }
        }
    }

    private fun exit() {
        println(resultList)
    }

    fun getResult(): IntArray = resultList.toIntArray()
}


sealed class Event {
    data class Add(val key: Int, val value: Int) : Event()
    data class Get(val key: Int) : Event()
    data class Remove(val key: Int) : Event()
    object Exit : Event()
    object Evict : Event()
    object Unknown : Event()
}

fun main(args: Array<String>){
    val A = arrayOf("add 5 3","add 1 2","get 5","evict","get 1")
    val operations = A.map {
        it.split(" ")
    }.map {
      when(it.first()){
          "add" -> Event.Add(it[1].toInt(),it[2].toInt())
          "get" -> Event.Get(it[1].toInt())
          "remove" -> Event.Remove(it[1].toInt())
          "exit" -> Event.Exit
          "evict" -> Event.Evict
          else -> Event.Unknown
      }
    }

    println( DataStructure(operations).apply {
        execute()
    }.getResult().toList())

}
