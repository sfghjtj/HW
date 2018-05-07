package com.zhw1.s1.s11.s21

/**
 * Created by sfghjtj on 2018/4/9.
 */
interface IQueue<T> {

    val item: MutableList<T>
    fun inQ(item: T)
    fun outQ(): T?

}