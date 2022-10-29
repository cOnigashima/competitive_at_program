package LDH

class SpecificChara {
}

// ある文字が重複しているかどうか？を調べる
// ない場合は０
// 重複している数がある場合は


fun main(args: Array<String>) {
    val text = "foobarbaz"
    val list = text.chunked(1)
    val groupedList = list.groupBy { it }.filter {
        it.value.size > 1
    }
    println(groupedList.size)
}