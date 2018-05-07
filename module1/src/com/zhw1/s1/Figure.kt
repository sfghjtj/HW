package com.zhw1.s1

/**
 * Created by sfghjtj on 2018/4/8.
 */
interface Figure {

    fun onDrow()
    val name: String
    val cname: String
        get() = "几何图形"

    fun display() {
        println(name)
    }
}