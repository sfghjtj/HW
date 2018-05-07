package com.zhw1.s1.s71

/**
 * Created by sfghjtj on 2018/4/17.
 */
fun main(args: Array<String>) {
    val a = TD("zhw", 34,"hzkd")
    val (_, _,s) = a
    println(s)
}


data class TD(var name: String, var age: Int,val school: String)
