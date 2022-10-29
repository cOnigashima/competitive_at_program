package AtCoderBeginnerContest275


//##.......
//##.......
//.........
//.......#.
//.....#...
//........#
//......#..
//.........
//.........
fun main(args: Array<String>) {
    val list : MutableList<String> = mutableListOf()
    for (i in 1..9){
        list.add(readLine()!!)
    }
    // .と#ごとに分析する
    // 座標とグラフ構造にしてやったほうが早いか・・・なるほど
}