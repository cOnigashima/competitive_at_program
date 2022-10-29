package AtCoderBeginnerContest275

fun main(args: Array<String>) {
    val a = "3"
    val b = "50 80 70"
    val list = b.split(" ", limit = a.toInt()).map { s ->
        s.toInt()
    }
    val result = list.indexOf(list.max()) + 1

    println("$result")
}
