package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
//    println(isE2<Int>(2,2))
//    var s: Int = 65
//    println(s is Int)
//    println(s.toChar())
//    val a = arrayListOf<Int>(12, 3, 4)
//    println(a.first)
    val a = hashMapOf(2 to 2, 1 to 4)
   // val b = Array(3,)
    val c = arrayListOf(2, 3, 4, 5)

    a.forEach { println("key=${it.key},value=${it.value}") }
   // b.forEachIndexed { index, i -> println("index=$index,value=$i") }

}
val <U> ArrayList<U>.first: U?
    get() = if(this.size>1) this[0] else null

fun isE(a: Int, b: Int): Boolean = a == b
fun <T> isE2(a: T, b: T): Boolean = a == b
fun <T, U> rect(a: T, b: U): U {
    TODO()
}