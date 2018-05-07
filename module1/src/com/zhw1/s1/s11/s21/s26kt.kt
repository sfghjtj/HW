package com.zhw1.s1.s11.s21

import java.io.FileInputStream


/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
    FileInputStream("").use {  }
    var users = listOf(User("tom", 123), User("zhw", 234)).onEach { println(it.name+"...") }
    val m = hashMapOf(1 to 2, 3 to 4).forEach{ println(it.key)}
    val datas = listOf(listOf(10, 20), listOf(20, 40))
    val d=IntArray(3){it+1}.reduce { acc, i ->acc*i }
    val a=IntArray(1000){it}.filter { it>=100 }.filter {
        val a1=it/100
        val b1=(it-a1*100)/10
        val c1=it%10
        it == a1*a1*a1+b1*b1*b1+c1*c1*c1
    }.forEach{ println(it)}
    val dd = datas.flatMap { it.map { it * 10 } }
    println(listOf(1, 2, 3).slice(0..2))
    println(users.filter { it.passwd > 123 })
    println(users.filterNot { it.passwd > 123 })
    println(users.map { it.passwd }.reduce { acc, i -> acc + i })
    users.filter { it.name.startsWith("t", ignoreCase = true) }.forEach { println(it.name) }
    users.uFilter { it.name.startsWith("t", ignoreCase = true) }.forEach { println(it) }
    users.filter { it.name.startsWith("t", ignoreCase = true) }.map { it.name }.forEach { println(it) }
}

fun fd(n: Int)=IntArray(3){it+1}.reduce { acc, i ->acc*i }

fun xsh()=IntArray(100)

data class User(var name: String, var passwd: Int)

inline fun <T> Iterable<T>.uFilter(predicate: (T) -> Boolean): List<T> {
    val des = ArrayList<T>()
    for (item in this) if (!predicate(item)) des.add(item)
    return des
}

inline fun <T, R> Iterable<T>.uMap(trans: (t: T) -> R): MutableList<R> {
    val des = ArrayList<R>()
    for (item in this) {
        des.add(trans(item))
    }
    return des
}

inline fun <T, S : T> Iterable<S>.reduce2(ope: (acc: T, S) -> S): S {
    val itr = this.iterator()
    if (!itr.hasNext()) throw UnsupportedOperationException("empty collection!")
    var t = itr.next()
    while (itr.hasNext()) {
        t = ope(t, itr.next())
    }
    return t

}

