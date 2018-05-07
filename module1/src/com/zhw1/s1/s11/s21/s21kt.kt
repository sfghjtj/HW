package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
//    val getArea: (Double, Double) -> Double = ::triang
//    println(getArea(1.2,3.4))
//    calp(1, 2, '+', funN = { a: Int, b: Int -> a + b })
//    calp(2,3,'+'){a,b-> a + b}//尾随lambda表达式
    cp(){a,b-> a + b}
    cp{a,b-> a + b}
    println(rstr("zhw"){ it.reversed()})

}


fun rstr(str: String, funN: (String) -> String):String {
    return funN(str)
}

fun triang(bottom: Double, height: Double) = 0.5 * bottom * height

fun calcute(opt: Char): (Int, Int) -> Int =
        when (opt) {
            '+' -> { a: Int, b: Int -> a + b }
            '-' -> { a: Int, b: Int -> a - b }
            '*' -> {
                fun(a: Int, b: Int) = a * b
            }
            else -> { a: Int, b: Int -> (a / b) }
        }


fun getAbyF(funName: (Double, Double) -> Double, a: Double, b: Double): Double = funName(a, b)
fun calp(a: Int, b: Int, opr: Char, funN: (Int, Int) -> Int) {
    println("$a $opr $b = ${funN(a,b)}")
}

fun cp(funN: (Int, Int) -> Int) {
    println("${funN(10, 5)}")

}
