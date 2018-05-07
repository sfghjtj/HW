package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
    var f1 = makeArray()
    println(f1(10))
    println(f1(10))
}

fun makeArray(): (Int) -> Int {
    var ary = 0
    /*fun add(e: Int): Int {
        ary += e
        return ary
    }
    return ::add*/
    return {
        ary += it
        ary
    }
}