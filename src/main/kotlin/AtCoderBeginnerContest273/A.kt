package AtCoderBeginnerContest273

import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()

    fun number(origin: Int) = if (origin > 0) origin else 1

    fun recursiveMultiplication(times: Int) : Int {

        return  if(times < 1) 1 else
        number(times) * recursiveMultiplication(times - 1)
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    println("${recursiveMultiplication(a)}")
}

