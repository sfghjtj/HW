package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
    val s= sum(1,23,10)
    println(s)

}

fun sum(vararg num: Int): Int {
    var total = 0

    num.forEach {
        if (it == 10) return@forEach
        total += it
    }
    return total
}