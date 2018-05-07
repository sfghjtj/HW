package com.zhw1

/**
 * Created by sfghjtj on 2018/4/4.
 */
class PrivateClass {

    private var x: Int = 0
    private fun printx() {
        println("value of x is" + x)

    }

    fun display() {
        x=100
        printx()
    }

}