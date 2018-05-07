package com.zhw1.s1.s11.s21

import com.zhw1.s1.Figure
import com.zhw1.s1.Triangle

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {

//    ope{a,b -> a + b}
//    ope{a,b -> a - b}
//    val n1: Int? = 300
//    n1?.let { println(it) }
    var f: Figure = Triangle("zhw")
    f.afterM {  }
    f.afterM2 {  }

}

class T {
    fun m1() {
        var f: Figure = Triangle("zhw")
        f.afterM2 {  }
    }
}

inline fun <T : Figure> T.afterM(f: T.(Int) -> Unit) {

}

inline fun <T : Figure> T.afterM2(f: (Int) -> Unit) {

}

fun squ(n: Int) = n * n
inline fun ope(funN: (Int, Int) -> Int) {
    println("${funN(10, 5)}")
}