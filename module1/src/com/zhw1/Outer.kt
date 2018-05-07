package com.zhw1

/**
 * Created by sfghjtj on 2018/4/4.
 */
class Outer {
    val x=10
    fun printOuter() = println("调用外部函数...")

    fun test() {
        val inner = Inner()
        inner.display()

    }

    inner class Inner {

        private val x = 5
        fun display() {
            println("外部类属性：${this@Outer.x}")
            println("内部类属性：${this.x}")
            println("内部类属性：$x")
            this@Outer.printOuter()
            printOuter()

        }
    }

}