package com.zhw1.s1.s51

//import com.beust.klaxon.json
import java.io.File
import java.util.*

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    //json {  }
    2.afterM1 {  }
    2.afterM2 { }
    val p = Person("zhw", 26)
    val a=with(p) {
        name="zzz"
        age=29
    }
    //println(a)
    //with3(2) { println(this)}
    A().b
    date {
        this.time
    }
}

inline fun <R> with3(obj: Int, block: Int.() -> R) = obj.block()


inline fun <T, R> with2(obj: T, block: T.() -> R) = obj.block()


data class Person(var name: String, var age: Int)


class A {
    val a: Unit=2.afterM2 { }
    val b: Unit=Date().afterM1 { println(this) }
}

inline fun <T> date(init: Date.() -> T) = Date().init()


inline fun<T>  T.afterM1(f: String.() -> Unit) {
    this.toString().f()
}

fun <T> T.afterM2(f: () -> Unit) {

}

fun af(): (Int)->Unit={ println(it)}