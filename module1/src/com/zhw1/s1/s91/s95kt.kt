package com.zhw1.s1.s91

import java.io.Serializable

/**
 * Created by sfghjtj on 2018/5/2.
 */
fun main(args: Array<String>) {
    val a = 2 as Serializable
    println(2L is Serializable)
    val b = CP1::playerId.get(C1())
    println(b)

}

interface P1 {
    fun primaryKey(): Serializable
}

interface CP1 : P1 {
    val playerId: Long
}

interface CP2 : CP1 {
    override fun primaryKey(): Serializable = playerId
}

class C1 : CP2 {
    override val playerId: Long
        get() = 2323L //To change initializer of created properties use File | Settings | File Templates.
}