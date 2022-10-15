package AtCoderBeginnerContest273


// 10で割って小数点で四捨五入した後に戻すがいいのか。
fun main(args: Array<String>) {
    // val (x, k) = readLine()!!.split(" ").map{ it.toLong() }
    val (x, k) = 314159265358979 to 12

    var output = x

    if((x / Math.pow((10).toDouble(), (k-1).toDouble())).toLong() == 0L){
        println("0")
        return
    }

    for (i in 0 .. k){
        val power = Math.pow((10).toDouble(), (i).toDouble())
        val result = Math.round(output / power)
        output = (result * power).toLong()
    }

    println("$output")
}


fun escape(){
    val (x, k) = 314159265358979 to 2
    var output = x

    fun shouldRoundOff(figureRank : Int) : Boolean{
        val power = Math.pow((10).toDouble(), (figureRank).toDouble())
        val remainder = Math.floor(output / power)
        val remainder2 = remainder % 10
        return remainder2 > 4
    }

    for (i in 0 until k) {
        if (shouldRoundOff(i)) {
            val power = (Math.pow((10).toDouble(), (i).toDouble()))
            val remainder = Math.floor(output / power).toLong()
            val remainder2 = (remainder % 10).toLong()
            output -= remainder2 * power.toInt()
            output += (Math.pow((10).toDouble(), (i+1).toDouble())).toLong()
        } else {
            val power = Math.pow((10).toDouble(), (i).toDouble())
            val remainder = Math.floor(output / power).toLong()
            val remainder2 = (remainder % 10)
            output -= remainder2
        }
    }
}
