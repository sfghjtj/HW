@file:Suppress("UNREACHABLE_CODE")

package com.zhw1.s1.s91

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by sfghjtj on 2018/5/3.
 */
fun main(args: Array<String>) {
    val a = 0..10
   println(fff(a))
//    val a2 =throw RuntimeException("")
//    val a3 = return
   // println(CT1().logger.simpleName)
}

class CT1 : T1() {

}

abstract class T1{
    val logger = javaClass

}

fun fff(a: IntRange):Long {
    a.forEach{it.toLong().let {
        it ->
        println(it)
        if (it> 4) return@let

    }}
    return 1000L
}

