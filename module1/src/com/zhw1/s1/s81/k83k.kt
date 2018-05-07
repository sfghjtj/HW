package com.zhw1.s1.s81

/**
 * Created by sfghjtj on 2018/4/25.
 */
fun main(args: Array<String>) {
    val t=B1(4)
//    B2(2,"fd").print()
}

interface Base {
    fun print()
}

class B1(val x: Int):Base{
    override fun print() {
        println("value is : $x")
    }
}

class B2(b: Base): Base by b
