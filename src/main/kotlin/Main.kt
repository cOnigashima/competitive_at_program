import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}


//　標準入力に対応できるようにしたい
val scanner = Scanner(System.`in`) //Scannerのインスタンスを作成
val s: String = scanner.nextLine()  //入力を行で取得
val i: Int = Integer.parseInt(s)//Int型に変換
val j: Int = scanner.nextInt()


fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = next().split(" ").map{ it.toInt() }
fun nextLongList() = next().split(" ").map{ it.toLong() }
fun nextDoubleList() = next().split(" ").map{ it.toDouble() }

fun abReadLine(){
    val (a, b) = readLine()!!.split(" ").map{ it.toInt() }
    if(a * b % 2 == 0) println("Even") else println("Odd")
}

fun main() {
    val reader = Scanner(System.`in`)
    // テストケース数
    val t = reader.nextInt()
    (1..t).map { x ->
        // 正方行列の大きさ
        val n = reader.nextInt()
        // 正方行列を格納するための二次元配列を作成
        val m = Array(n) { IntArray(n)  /* 各要素を初期化するブロック */ }
        // 正方行列を読み込む
        (0 until n).map { i ->
            (0 until n).map { j ->
                m[i][j] = reader.nextInt()
            }
        }
        // 答えを作る
        // 対角成分の合計
        val k = (0 until n).sumBy { m[it][it] }
        // 重複要素のある行の数
        val r = (0 until n).map { m[it] }.map { it.distinct().size != n }.count { it }
        // 重複要素のある列の数
        val c = (0 until n).map { j -> (0 until n).map { m[it][j] } }.
        map { it.distinct().size != n }.count { it }
        // 結果出力
        println("Case #%d: %d %d %d".format(x, k, r, c))
    }
}