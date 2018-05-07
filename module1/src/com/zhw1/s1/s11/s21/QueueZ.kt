package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
fun main(args: Array<String>) {
    val l = QueueZ<String>()
    l.inQ("z")
    l.inQ("h")
    l.inQ("w")
    println(l.outQ())

}
class QueueZ<T> {

    private val item: MutableList<T>

    init {
        item = ArrayList<T>()
    }

    /**
     * 入队函数
     */
    fun inQ(a: T) {
        item.add(a)
    }

    fun outQ(): T?=if(item.isEmpty()) null else item.removeAt(0)
}