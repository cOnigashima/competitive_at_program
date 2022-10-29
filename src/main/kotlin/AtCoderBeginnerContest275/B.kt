package AtCoderBeginnerContest275

fun main(args: Array<String>) {
    val list = "1 1 1000000000 0 0 0"
    val splited = list.split(" ", limit = 6)

    val a = splited[0]
    val b = splited[1]
    val c = splited[2]
    val d = splited[3]
    val e = splited[4]
    val f = splited[5]
    val divide = 998244353L

    val ab = multiple(a,b)
    val abc = multiple(ab,c)

    val de = multiple(d,e)
    val def = multiple(de,f)

    val abcMinusDef = abc - def
    val rest = abcMinusDef % divide

    println("$rest")
}


// 掛け算をする
fun multiple(fromA: String, fromB: String): String {
    // todo このやり方だと、reverseしないといけない
    val a = fromA.map { it.digitToInt() }
    val b = fromB.map { it.digitToInt() }
    val result: MutableList<Int> = mutableListOf()

    a.forEachIndexed { indexA , elementA ->
        b.forEachIndexed { indexB, elementB ->
            val index = indexA + indexB
            val tmp = elementA * elementB

            // どうしてもoutOfBoundsになってしまう
            if (result.size < index ) result.add(index, 0)
            result[index] = result[index] +(tmp % 10)

            if(result[index] >= 10){
                result[index] = result[index] -10
                result[index + 1] = result[index + 1] + 1
            }

            if (tmp > 10) {
                result[index + 1] =  result[index + 1] + (tmp / 10)
            }
        }
    }
    return result.toString()
}

// 引き算するを英語でいうと、subtractionになります。
//  subtractionは、動詞subtract（～で引く）の名詞形です。subtract A from B（BからAをひく）
//  deduct A from B（BからAを差し引く）
//  by
fun substraction(by: String, target: String) : String {
    // B - A ね
    val result : MutableList<String> = mutableListOf()
    target.forEachIndexed { targetI, targetS ->
        by.forEachIndexed { indexBy, byS ->

        }
    }
    return ("センスがない！！！！！")
}

// 割り算をする


// 一般に非負整数 A,B および正整数 M について、
// (A∗B)%M=((A%M)∗(B%M))%Mが成り立つ事に注意すれば,
// 計算前に各変数について, 998244353 で割ったあまりを求めた後に積を取れば良いと分かります。
// いや、そうだようなぁ。。