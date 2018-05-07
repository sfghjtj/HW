package com.zhw1.s1.s91

/**
 * Created by sfghjtj on 2018/5/2.
 */
fun main(args: Array<String>) {
    val a = arrayListOf<String>()

    (0 until 10).mapTo(a, Int::toString)

    println(a)
}