package LDH


// ３桁区切り
class FormattedString {
 // 12345がintで終わって欲しいって
}

fun main(args: Array<String>){
    val S = "123456700"
    val result =  "%,f".format(S.toDouble())
    val regex = Regex(".0+\$")
    println( regex.replace(result,"") )
}