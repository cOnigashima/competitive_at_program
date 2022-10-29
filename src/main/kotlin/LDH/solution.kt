package LDH


// For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
// Given A = [1, 2, 3], the function should return 4.
// Given A = [−1, −3], the function should return 1.

fun main(args: Array<String>) {

    // val A = arrayOf(1, 3, 6, 4, 1, 2)
    //val A = arrayOf(1, 3, 2)
    val A = arrayOf(-1, -3, 2)
    // write your code in Kotlin 1.6.0 (Linux)
    var candidate = 1
    A.sort()
    A.forEachIndexed { index: Int, i: Int ->
        if(index + 1 >= A.size) {
            if(candidate == 1) {
                candidate = A[index] + 1
                return@forEachIndexed
            }
            return@forEachIndexed
        }

        if(i+1 == A[index+1]) return@forEachIndexed
        else {
            candidate = if(i+1 == 0) 1 else i+1
            return@forEachIndexed
        }
    }
    println(candidate)
}
